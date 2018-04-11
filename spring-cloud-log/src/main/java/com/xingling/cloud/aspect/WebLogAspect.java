package com.xingling.cloud.aspect;

import com.xingling.cloud.model.domain.Log;
import com.xingling.cloud.service.LogService;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>Title:      WebLogAspect. </p>
 * <p>Description Web层日志切面 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    北京云杉世界信息技术有限公司 </p>
 *
 * @author <a href="yangwensheng@meicai.cn"/>杨文生</a>
 * @since 2018 /1/6 16:31
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    private ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    @Resource
    private LogService logService;

    /**
     * Web log.
     */
    @Pointcut("execution(public * com.xingling.cloud.web..*.*(..))")
    public void webLog(){}

    /**
     * Do before.
     *
     * @throws Throwable the throwable
     */
    @Before("webLog()")
    public void doBefore(){
        this.threadLocal.set(new Date(System.currentTimeMillis()));
    }

    /**
     * Do after.
     *
     * @param joinPoint the join point
     * @throws Exception the exception
     */
    @AfterReturning(pointcut = "webLog()", returning = "returnValue")
    public void doAfter(JoinPoint joinPoint,Object returnValue){
        // 获取HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取要记录的日志内容
        try {
            Log log = buildLog(request, joinPoint,returnValue);
            logService.insert(log);
        } catch (Exception ex) {
            logger.error("保存日志出现异常={}", ex.getMessage(), ex);
        }
    }

    private Log buildLog(HttpServletRequest request, JoinPoint joinPoint ,Object returnValue) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取客户端操作系统
        String os = userAgent.getOperatingSystem().getName();
        //获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        Date startTime = this.threadLocal.get();
        Date endTime = new Date(System.currentTimeMillis());
        Log log = new Log();
        log.setClassName(joinPoint.getTarget().getClass().getName());
        log.setMethodName(joinPoint.getSignature().getName());
        log.setExcuteTime(new Long(endTime.getTime() - startTime.getTime()).intValue());
        log.setStartTime(startTime);
        log.setEndTime(endTime);
        log.setIp(request.getRemoteAddr());
        log.setOs(os);
        log.setBrowser(browser);
        log.setRequestUrl(request.getRequestURL().toString());
        log.setRequestURI(request.getRequestURI());
        log.setRemotePort(request.getRemotePort());
        log.setLocalAddr(request.getLocalAddr());
        log.setLocalName(request.getLocalName());
        log.setArgs(Arrays.toString(joinPoint.getArgs()));
        log.setParameters(request.getParameterMap());
        log.setHeaders(getHeadersInfo(request));
        log.setResponseData(String.valueOf(returnValue));
        return log;
    }

    /**
     * <p>Title:      getHeadersInfo. </p>
     * <p>Description 获取头信息</p>
     *
     * @param      request   HttpServletRequest
     * @return     Map<String, String>
     * @Author        <a href="yangwensheng@meicai.cn"/>杨文生</a>
     * @since     2018/1/6 17:10
     */
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

}


package com.xingling.cloud.aspect;

import com.xingling.cloud.exception.BusinessException;
import com.xingling.cloud.annotation.ValidateAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * <p>Title:      BindingResultAop. </p>
 * <p>Description 校验aop </p>
 * <p>Company:    xinglinglove </p>
 *
 * @author         <a href="190332447@qq.com"/>杨文生</a>
 * @since      2018/1/6 18:12
 */
@Component
@Aspect
public class BindingResultAop {
    private static final Logger logger = LoggerFactory.getLogger(BindingResultAop.class);

    private ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    /**
     * Validate annotation.
     */
    @Pointcut("@annotation(com.xingling.cloud.annotation.ValidateAnnotation)")
    public void ValidateAnnotation() {
    }

    /**
     * Do before.
     */
    @Before("ValidateAnnotation()")
    public void doBefore() {
        this.threadLocal.set(new Date(System.currentTimeMillis()));
    }

    /**
     * Do after.
     *
     * @param joinPoint the join point
     * @throws Exception the exception
     */
    @AfterReturning(pointcut = "ValidateAnnotation()")
    public void doAfter(final JoinPoint joinPoint) throws Exception {
        String methodName = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        //得到拦截的方法
        Method method = getMethodByClassAndName(target.getClass(), methodName);
        Object[]  objects = joinPoint.getArgs();
        //方法的参数
        ValidateAnnotation annotation = (ValidateAnnotation)getAnnotationByMethod(method ,ValidateAnnotation.class );
        if(annotation != null){
            BindingResult bindingResult = null;
            for(Object arg : objects){
                if(arg instanceof BindingResult){
                    bindingResult = (BindingResult) arg;
                }
            }
            if(bindingResult != null){
                if(bindingResult.hasErrors()){
                    String errorInfo=bindingResult.getFieldError().getDefaultMessage();
                    throw  new BusinessException(errorInfo);
                }
            }
        }
    }

    /**
     * 根据目标方法和注解类型  得到该目标方法的指定注解
     *
     * @param method    the method
     * @param annoClass the anno class
     * @return the annotation
     */
    public Annotation getAnnotationByMethod(Method method , Class annoClass){
        Annotation all[] = method.getAnnotations();
        for (Annotation annotation : all) {
            if (annotation.annotationType() == annoClass) {
                return annotation;
            }
        }
        return null;
    }

    /**
     * 根据类和方法名得到方法
     *
     * @param c          the c
     * @param methodName the method name
     * @return the method
     */
    public Method getMethodByClassAndName(Class c , String methodName){
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if(method.getName().equals(methodName)){
                return method ;
            }
        }
        return null;
    }
}

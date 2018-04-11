package com.xingling.cloud.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title:	  spring-cloud-koala <br/> </p>
 * <p>Description 未前后端分离的全局异常处理 <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017 /12/28 10:03
 */
@ControllerAdvice
public class ViewGlobalExceptionHandler {

    /**
     * The constant DEFAULT_ERROR_VIEW.
     */
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * Default error handler model and view.
     *
     * @param request the request
     * @param ex      the ex
     * @return the model and view
     * @throws Exception the exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception ex) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }
}

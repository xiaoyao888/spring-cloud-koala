package com.xingling.cloud.annotation;

import java.lang.annotation.*;

/**
 * <p>Title:	  ValidateAnnotation. </p>
 * <p>Description 校验注解 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/3/27 11:43
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateAnnotation {
    boolean isValidate() default true;
}
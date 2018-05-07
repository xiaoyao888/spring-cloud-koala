package com.xingling.cloud.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;


public class SecurityUserUtils {

    /**
     * <p>Title:      getCurrentLoginName. </p>
     * <p>Description 获取当前登录人信息</p>
     *
     * @return
     * @Author        <a href="190332447@qq.com"/>杨文生</a>
     * @since     2018/1/10 17:40
     */
    public static String getCurrentLoginName() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        if (principal instanceof Principal) {
            return ((Principal) principal).getName();
        }

        return String.valueOf(principal);
    }
}

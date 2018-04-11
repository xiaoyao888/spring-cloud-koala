package com.xingling.cloud.config;

import com.xingling.cloud.service.impl.SecurityUserDetailsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>Title:      AuthenticationBeanConfig. </p>
 * <p>Description 认证相关的扩展点配置。配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    xinglinglove </p>
 *
 * @author         <a href="190332447@qq.com"/>杨文生</a>
 * @since      2018/2/7 18:47
 */
@Configuration
public class AuthenticationBeanConfig {

	/**
	 * 默认密码处理器
	 *
	 * @return password encoder
	 */
	@Bean
	@ConditionalOnMissingBean(PasswordEncoder.class)
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 默认认证器
	 *
	 * @return user details service
	 */
	@Bean
	@ConditionalOnMissingBean(UserDetailsService.class)
	public UserDetailsService userDetailsService() {
		return new SecurityUserDetailsService();
	}


}

package com.xingling.cloud.config;

import com.xingling.cloud.constant.SecurityConstants;
import com.xingling.cloud.security.Authentication.CustomerAuthenticationFailureHandler;
import com.xingling.cloud.security.Authentication.CustomerAuthenticationSuccessHandler;
import com.xingling.cloud.security.CustomerLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * <p>Title:      FormAuthenticationConfig. </p>
 * <p>Description 表单登录配置 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    xinglinglove </p>
 *
 * @author         <a href="190332447@qq.com"/>杨文生</a>
 * @since      2018/2/7 18:47
 */
@Component
public class FormAuthenticationConfig {


	protected final AuthenticationSuccessHandler customerAuthenticationSuccessHandler;


	protected final AuthenticationFailureHandler customerAuthenticationFailureHandler;

	protected final CustomerLogoutSuccessHandler customerLogoutSuccessHandler;

	@Autowired
	public FormAuthenticationConfig(CustomerAuthenticationSuccessHandler customerAuthenticationSuccessHandler, CustomerAuthenticationFailureHandler customerAuthenticationFailureHandler, CustomerLogoutSuccessHandler customerLogoutSuccessHandler) {
		this.customerAuthenticationSuccessHandler = customerAuthenticationSuccessHandler;
		this.customerAuthenticationFailureHandler = customerAuthenticationFailureHandler;
		this.customerLogoutSuccessHandler = customerLogoutSuccessHandler;
	}


	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
			.successHandler(customerAuthenticationSuccessHandler)
			.failureHandler(customerAuthenticationFailureHandler);
		http.logout().logoutUrl(SecurityConstants.DEFAULT_LOGOUT_URL).logoutSuccessHandler(customerLogoutSuccessHandler);
		;
	}
}

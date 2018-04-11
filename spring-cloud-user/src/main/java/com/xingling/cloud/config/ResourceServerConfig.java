package com.xingling.cloud.config;

import com.xingling.cloud.security.authorize.AuthorizeConfigManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title:	  ResourceServerConfig <br/> </p>
 * <p>Description 资源访问配置 <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017/1/6 19:36
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private FormAuthenticationConfig formAuthenticationConfig;

    @Resource
    private AuthorizeConfigManager authorizeConfigManager;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("xinglinglove").stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        formAuthenticationConfig.configure(http);
        http.headers().frameOptions().disable();
        http
            .csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
            .headers().frameOptions().disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }
}

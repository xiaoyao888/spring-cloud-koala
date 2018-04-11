package com.xingling.cloud.config.web;

import com.xingling.cloud.interceptor.VueTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Title:	  WebMvcConfig <br/> </p>
 * <p>Description 拦截器 <br/> </p>
 * <p>Company:    http://www.hnxianyi.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2018/2/8 14:29
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Resource
	private VueTokenInterceptor vueTokenInterceptor;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
		registry.addInterceptor(vueTokenInterceptor).addPathPatterns("/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
		super.addInterceptors(registry);
	}

	private ArrayList<String> getExcludeCommonPathPatterns() {
		ArrayList<String> list = new ArrayList<>();
		String[] urls = {
				"/v2/api-docs",
				"/swagger-resources/**"
		};
		Collections.addAll(list, urls);
		return list;
	}
}

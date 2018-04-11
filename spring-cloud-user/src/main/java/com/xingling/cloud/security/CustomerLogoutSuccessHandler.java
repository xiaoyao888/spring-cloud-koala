package com.xingling.cloud.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingling.wrap.WrapMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Title:      CustomerLogoutSuccessHandler. </p>
 * <p>Description 默认的退出成功处理器 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    北京云杉世界信息技术有限公司 </p>
 *
 * @author         <a href="yangwensheng@meicai.cn"/>杨文生</a>
 * @since      2018/2/7 11:17
 */
@Component("customerLogoutSuccessHandler")
@Slf4j
public class CustomerLogoutSuccessHandler implements LogoutSuccessHandler {

	@Resource
	private RedisTokenStore redisTokenStore;

	private ObjectMapper objectMapper = new ObjectMapper();

	private static final String BEARER_AUTHENTICATION = "Bearer ";

	private static final String HEADER_AUTHORIZATION = "authorization";


	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		log.info("退出成功");
		String token = request.getHeader(HEADER_AUTHORIZATION);

		if (token != null && token.startsWith(BEARER_AUTHENTICATION)) {

			OAuth2AccessToken oAuth2AccessToken = redisTokenStore.readAccessToken(token.split(" ")[0]);

			if (oAuth2AccessToken != null) {
				redisTokenStore.removeAccessToken(oAuth2AccessToken);
			}

		}
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(WrapMapper.ok("退出成功")));
	}

}

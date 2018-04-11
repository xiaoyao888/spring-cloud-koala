package com.xingling.cloud.config.email;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Data
@Component
public class EmailConfig {

	//@Value("${spring.mail.username}")
	private String defaultFrom;

}

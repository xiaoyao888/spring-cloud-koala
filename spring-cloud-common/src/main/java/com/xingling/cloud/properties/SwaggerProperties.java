package com.xingling.cloud.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title:	  SwaggerProperties. </p>
 * <p>Description swagger </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/8/18 13:48
 */
@Configuration
@ConfigurationProperties(prefix = SwaggerProperties.SWAGGER_PREFIX)
@Data
public class SwaggerProperties {

	public final static String SWAGGER_PREFIX="swagger";

	private String title = "系统API接口管理";

	private String description;

	private String version = "1.0";

	private String license = "Apache License 2.0";

	private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

	private String contactName = "杨文生";

	private String contactUrl = "http://xinglinglove.com";

	private String contactEmail = "190332447@qq.com";

	private String basePackage = "com.xingling.cloud.web.controller";

	private String groupName = "xinglinglove";
}

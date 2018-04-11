package com.xingling.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = RestConfig.REST_PREFIX)
@Data
public class RestConfig {

    public final static String REST_PREFIX="restful";


    /**
     * 用户中心的URL地址
     */
    private String umc;
}

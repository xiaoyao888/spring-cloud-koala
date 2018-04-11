package com.xingling.cloud.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title:      RocketMqProperties. </p>
 * <p>Description RocketMqProperties </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    xinglinglove </p>
 *
 * @author <a href="yangwensheng@meicai.cn"/>杨文生</a>
 * @since 2018/1/29 11:17
 */
@Configuration
@ConfigurationProperties(prefix = RocketMqProperties.ROCKET_MQ)
@Data
public class RocketMqProperties {

    public final static String ROCKET_MQ = "rocketMq";

    private String defaultProducerGrouopName;

    private String transactionProducerGroupName;

    private String namesrvAddr;

    private String instanceName;

    private int maxMessageSize;

    private int sendMsgTimeout;

    private String topic;

    private String tag;

    private int consumeThreadMin;

    private int consumeThreadMax;
}

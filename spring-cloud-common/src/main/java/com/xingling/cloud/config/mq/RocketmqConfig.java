package com.xingling.cloud.config.mq;

import com.xingling.cloud.exception.RocketMQException;
import com.xingling.cloud.properties.RocketMqProperties;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * <p>Title:	  RocketmqConfig <br/> </p>
 * <p>Description rocketmq配置 <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017/8/3 17:10
 */
//@Configuration
@EnableConfigurationProperties(RocketMqProperties.class)
public class RocketmqConfig {

    public static final Logger LOGGER = LoggerFactory.getLogger(RocketmqConfig.class);

    @Autowired
    private RocketMqProperties rocketMqProperties;

    @Autowired
    @Qualifier("messageProcessorImpl")
    private MessageProcessor messageProcessor;

    @Bean
    public DefaultMQProducer getRocketMQProducer() throws RocketMQException {
        DefaultMQProducer producer;
        producer = new DefaultMQProducer(rocketMqProperties.getDefaultProducerGrouopName());
        producer.setNamesrvAddr(rocketMqProperties.getNamesrvAddr());
        producer.setInstanceName(rocketMqProperties.getInstanceName());
        producer.setMaxMessageSize(rocketMqProperties.getMaxMessageSize());
        producer.setSendMsgTimeout(rocketMqProperties.getSendMsgTimeout());
        try {
            producer.start();
            LOGGER.info(String.format("DefaultMQProducer is start ! groupName:[%s],namesrvAddr:[%s]", rocketMqProperties.getDefaultProducerGrouopName(), rocketMqProperties.getNamesrvAddr()));
        } catch (MQClientException e) {
            LOGGER.error(String.format("DefaultMQProducer is error {}", e.getMessage(), e));
            throw new RocketMQException(e);
        }
        LOGGER.info("DefaultMQProducer TransactionMQProducer Started.");
        return producer;
    }

    @Bean
    public TransactionMQProducer transactionProducer() throws RocketMQException {
        /**
         * 一个应用创建一个Producer，由应用来维护此对象，可以设置为全局对象或者单例<br>
         * 注意：ProducerGroupName需要由应用来保证唯一<br>
         * ProducerGroup这个概念发送普通的消息时，作用不大，但是发送分布式事务消息时，比较关键，
         * 因为服务器会回查这个Group下的任意一个Producer
         */
        TransactionMQProducer producer = new TransactionMQProducer(rocketMqProperties.getTransactionProducerGroupName());
        producer.setNamesrvAddr(rocketMqProperties.getNamesrvAddr());
        producer.setInstanceName(rocketMqProperties.getInstanceName());
        // 事务回查最小并发数
        producer.setCheckThreadPoolMinSize(2);
        // 事务回查最大并发数
        producer.setCheckThreadPoolMaxSize(2);
        // 队列数
        producer.setCheckRequestHoldMax(2000);
        try {
            producer.start();
            LOGGER.info(String.format("TransactionMQProducer is start ! groupName:[%s],namesrvAddr:[%s]", rocketMqProperties.getDefaultProducerGrouopName(), rocketMqProperties.getNamesrvAddr()));
        } catch (MQClientException e) {
            LOGGER.error(String.format("TransactionMQProducer is error {}", e.getMessage(), e));
            throw new RocketMQException(e);
        }
        LOGGER.info("RocketMq TransactionMQProducer Started.");
        return producer;
    }

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() throws RocketMQException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketMqProperties.getDefaultProducerGrouopName());
        consumer.setNamesrvAddr(rocketMqProperties.getNamesrvAddr());
        consumer.setConsumeThreadMin(rocketMqProperties.getConsumeThreadMin());
        consumer.setConsumeThreadMax(rocketMqProperties.getConsumeThreadMax());
        MessageListener messageListener = new MessageListener();
        messageListener.setMessageProcessor(messageProcessor);
        consumer.registerMessageListener(messageListener);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);//延迟5秒再启动，主要是等待spring事件监听相关程序初始化完成，否则，回出现对RocketMQ的消息进行消费后立即发布消息到达的事件，然而此事件的监听程序还未初始化，从而造成消息的丢失
                    /**
                     * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
                     */
                    try {
                        consumer.subscribe(rocketMqProperties.getTopic(), rocketMqProperties.getTag());
                        consumer.start();
                        LOGGER.info("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}", rocketMqProperties.getDefaultProducerGrouopName(), rocketMqProperties.getTopic(), rocketMqProperties.getNamesrvAddr());
                    } catch (Exception e) {
                        LOGGER.error("consumer is start !!! groupName:{},topic:{},namesrvAddr:{}", rocketMqProperties.getDefaultProducerGrouopName(), rocketMqProperties.getTopic(), rocketMqProperties.getNamesrvAddr(), e);
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        return consumer;
    }

}


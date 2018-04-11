package com.xingling.cloud.config.mq;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * <p>Title:	  koala-umc <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017/8/4 12:56
 */
public interface MessageProcessor {
	/**
	 * 处理消息的接口
	 * @param messageExt
	 * @return
	 */
	boolean handleMessage(MessageExt messageExt);
}

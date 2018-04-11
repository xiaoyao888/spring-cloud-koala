package com.xingling.cloud.service;

import com.xingling.cloud.dto.robot.ChatRobotMsgDto;
import com.xingling.cloud.model.domain.Message;
import com.xingling.service.mybatis.BaseService;

/**
 * <p>Title:	  UserService <br/> </p>
 * <p>Description 钉钉机器人service <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017 /5/15 13:49
 */
public interface ChatRobotService extends BaseService<Message> {

	/**
	 * <p>Title:      sendChatRobotMsg. </p>
	 * <p>Description 钉钉机器人推送消息</p>
	 *
	 * @param chatRobotMsgDto the chat robot msg dto
	 * @return boolean boolean
	 * @throws Exception the exception
	 * @Author <a href="yangwensheng@meicai.cn"/>杨文生</a>
	 * @since 2017 /12/27 16:59
	 */
	boolean sendChatRobotMsg(ChatRobotMsgDto chatRobotMsgDto);
}

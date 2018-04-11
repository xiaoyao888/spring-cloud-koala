package com.xingling.cloud.dto.robot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title:      ChatRobotMsgDto. </p>
 * <p>Description 自定义机器人消息 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2017 /12/12 16:57
 */
@Data
@ApiModel(value = "自定义机器人消息体")
public class ChatRobotMsgDto implements Serializable{

	private static final long serialVersionUID = -9132398786027223009L;

	/**
	 * 机器人URL
	 */
	@ApiModelProperty(value = "机器人URL")
	private String webhookToken;

	/**
	 * 此消息类型为固定markdown
	 * @link MsgTypeEnum.java
	 */
	@ApiModelProperty(value = "首屏会话透出的展示内容", required = true)
	@JsonProperty(value = "msgtype")
	private String msgType;

	/**
	 * markdown消息体
	 */
	@ApiModelProperty(value = "markdown消息体")
	private MarkdownDto markdown;

	/**
	 * link类型
	 */
	@ApiModelProperty(value = "link类型")
	private LinkDto link;
	/**
	 * link类型
	 */
	@ApiModelProperty(value = "link类型")
	private TextDto text;
	/**
	 * link类型
	 */
	@ApiModelProperty(value = "link类型")
	private AtDto at;

}

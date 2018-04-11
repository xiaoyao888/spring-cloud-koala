package com.xingling.cloud.dto.robot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title:      MarkdownDto. </p>
 * <p>Description markdown </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2017 /12/12 16:58
 */
@Data
@ApiModel(value = "link类型")
public class MarkdownDto implements Serializable {
	private static final long serialVersionUID = 5169795915361197484L;
	/**
	 * 首屏会话透出的展示内容
	 */
	@ApiModelProperty(value = "首屏会话透出的展示内容", required = true)
	private String title;
	/**
	 * markdown格式的消息
	 */
	@ApiModelProperty(value = "markdown格式的消息", required = true)
	private String text;
}

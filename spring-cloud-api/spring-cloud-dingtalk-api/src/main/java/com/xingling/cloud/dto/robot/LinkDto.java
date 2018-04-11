package com.xingling.cloud.dto.robot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Title:      LinkDto. </p>
 * <p>Description TODO </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2017 /12/12 16:57
 */
@Data
@ApiModel(value = "link类型")
public class LinkDto {
	@ApiModelProperty(value = "消息标题", required = true)
	private String title;
	@ApiModelProperty(value = "消息内容。如果太长只会部分展示", required = true)
	private String text;
	@ApiModelProperty(value = "点击消息跳转的URL", required = true)
	private String messageUrl;
	@ApiModelProperty(value = "图片URL")
	private String picUrl;
}

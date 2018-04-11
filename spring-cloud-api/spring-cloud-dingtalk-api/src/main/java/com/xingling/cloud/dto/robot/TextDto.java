package com.xingling.cloud.dto.robot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title:      TextDto. </p>
 * <p>Description TextDto </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2017 /12/12 16:58
 */
@Data
@ApiModel(value = "text类型")
public class TextDto implements Serializable{
	private static final long serialVersionUID = 8825625125019746717L;
	@ApiModelProperty(value = "消息内容", required = true)
	private String content;
}

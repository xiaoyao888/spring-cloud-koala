package com.xingling.cloud.dto.robot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title:      AtDto. </p>
 * <p>Description TODO </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2017 /12/12 16:57
 */
@Data
@ApiModel(value = "AtDto")
public class AtDto implements Serializable {
	private static final long serialVersionUID = 2344037651462081640L;
	/**
	 * 被@人的手机号
	 */
	@ApiModelProperty(value = "被@人的手机号")
	private String[] atMobiles;
	/**
	 * \@所有人时:true,否则为:false
	 */
	@ApiModelProperty(value = "@所有人时:true,否则为:false")
	private boolean isAtAll;
}

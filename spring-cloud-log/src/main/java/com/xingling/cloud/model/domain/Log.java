package com.xingling.cloud.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xingling.pojo.BaseEntiy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
@Document(collection = "xl_log")
@ApiModel(value = "日志实体")
public class Log extends BaseEntiy implements Serializable {

	private static final long serialVersionUID = -5606865665592482762L;

	/**
	 * 流水号
	 */
	@ApiModelProperty(value = "流水号")
	private String serialNo;

	/**
	 * 中心类型
	 * @link LogTypeEnum
	 */
	@ApiModelProperty(value = "中心类型")
	private String fromSysType;

	/**
	 * 中心类型名称
	 * @link LogTypeEnum
	 */
	@ApiModelProperty(value = "中心类型名称")
	private String fromSysName;

	/**
	 * 操作系统
	 */
	@ApiModelProperty(value = "操作系统")
	private String os;

	/**
	 * 浏览器类型
	 */
	@ApiModelProperty(value = "浏览器类型")
	private String browser;

	/**
	 * IP地址
	 */
	@ApiModelProperty(value = "IP地址")
	private String ip;

	/**
	 * 物理地址
	 */
	@ApiModelProperty(value = "物理地址")
	private String mac;

	/**
	 * 远程端口
	 */
	@ApiModelProperty(value = "远程端口")
	private int remotePort;

	/**
	 * 本机地址
	 */
	@ApiModelProperty(value = "本机地址")
	private String localAddr;

	/**
	 * 本机名称
	 */
	@ApiModelProperty(value = "本机名称")
	private String localName;

	/**
	 * 请求头
	 */
	@ApiModelProperty(value = "请求头")
	private Map<String, String> headers;

	/**
	 * 请求完整地址
	 */
	@ApiModelProperty(value = "请求完整地址")
	private String requestUrl;

	/**
	 * 请求地址
	 */
	@ApiModelProperty(value = "请求地址")
	private String requestURI;

	/**
	 * 响应结果
	 */
	@ApiModelProperty(value = "响应结果")
	private String responseData;

	/**
	 * 类名
	 */
	@ApiModelProperty(value = "类名")
	private String className;

	/**
	 * 方法名
	 */
	@ApiModelProperty(value = "方法名")
	private String methodName;

	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;

	/**
	 * 耗时,秒
	 */
	@ApiModelProperty(value = "耗时,秒")
	private Integer excuteTime;

	/**
	 * 请求参数
	 */
	@ApiModelProperty(value = "请求参数")
	private Map<String, String[]> parameters;

	/**
	 * 方法请求参数
	 */
	@ApiModelProperty(value = "方法请求参数")
	private String args;

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("serialNo", serialNo)
				.append("fromSysType", fromSysType)
				.append("fromSysName", fromSysName)
				.append("os", os)
				.append("browser", browser)
				.append("ip", ip)
				.append("mac", mac)
				.append("remotePort", remotePort)
				.append("localAddr", localAddr)
				.append("localName", localName)
				.append("headers", headers)
				.append("requestUrl", requestUrl)
				.append("requestURI", requestURI)
				.append("responseData", responseData)
				.append("className", className)
				.append("methodName", methodName)
				.append("startTime", startTime)
				.append("endTime", endTime)
				.append("excuteTime", excuteTime)
				.append("parameters", parameters)
				.append("args", args)
				.toString();
	}
}
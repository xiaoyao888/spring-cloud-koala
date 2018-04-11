package com.xingling.cloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "用户信息")
public class UserDto implements Serializable {

	private static final long serialVersionUID = -6344091218934186485L;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String userName;

	/**
	 * 真实姓名
	 */
	@ApiModelProperty(value = "真实姓名")
	private String realName;
	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	private String sex;
	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄")
	private Integer age;
	/**
	 * 出生日期
	 */
	@ApiModelProperty(value = "出生日期")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthday;
	/**
	 * 电话
	 */
	@ApiModelProperty(value = "电话")
	private String cellPhone;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	private String email;
	/**
	 * 地址
	 */
	@ApiModelProperty(value = "地址")
	private String address;
	/**
	 * 城市
	 */
	@ApiModelProperty(value = "城市")
	private String city;
	/**
	 * 国家
	 */
	@ApiModelProperty(value = "国家")
	private String country;
	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private Integer status;
	/**
	 * 盐值
	 */
	@ApiModelProperty(value = "盐值")
	private String salt;
	/**
	 * 最近登录时间
	 */
	@ApiModelProperty(value = "用户编号")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date  lastLoginDate;
}
package com.xingling.cloud.web.controller;

import com.xingling.cloud.dto.UserDto;
import com.xingling.cloud.dto.robot.ChatRobotMsgDto;
import com.xingling.cloud.service.ChatRobotService;
import com.xingling.cloud.service.UserFeignClientApi;
import com.xingling.controller.BaseController;
import com.xingling.wrap.WrapMapper;
import com.xingling.wrap.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>Title:	  MessageController. </p>
 * <p>Description 消息controller </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate 2017 /8/17 19:05
 */
@RestController
@RequestMapping(value = "/message")
@Api(value = "MessageController", tags = "MessageController", description = "消息controller", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageController extends BaseController{

	@Autowired
	private DiscoveryClient discoveryClient;

	@Resource
	private ChatRobotService chatRobotService;

	@Resource
	private UserFeignClientApi userFeignClientApi;

	/**
	 * <p>Title:	  showInfo. </p>
	 * <p>Description 本地服务实例的信息</p>
	 *
	 * @return the service instance
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @CreateDate 2017 /8/17 19:05
	 */
	@GetMapping("/instance-info")
	@ApiOperation(notes = "本地服务实例的信息", httpMethod = "GET", value = "本地服务实例的信息")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

	/**
	 * <p>Title:      sendChatRobotMsg. </p>
	 * <p>Description 发送钉钉消息</p>
	 *
	 * @param chatRobotMsgDto the chat robot msg dto
	 * @return user boolean
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /11/6 17:54
	 */
	@PostMapping("/sendChatRobotMsg")
	@ApiOperation(notes = "发送钉钉消息", httpMethod = "POST", value = "发送钉钉消息")
	public Wrapper<Boolean> sendChatRobotMsg(@RequestBody ChatRobotMsgDto chatRobotMsgDto) {
		boolean result = chatRobotService.sendChatRobotMsg(chatRobotMsgDto);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
	}

	/**
	 * <p>Title:      queryUserByUserName. </p>
	 * <p>Description 使用feign的方式调用</p>
	 *
	 * @param userName the user name
	 * @return user wrapper
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /11/6 17:54
	 */
	@GetMapping("/queryUserByUserName/{userName}")
	@ApiOperation(notes = "使用feign的方式调用", httpMethod = "GET", value = "使用feign的方式调用")
	public Wrapper<UserDto> queryUserByUserName(@PathVariable String userName) {
		Wrapper<UserDto> wrapper = this.userFeignClientApi.queryUserByUserName(userName);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, wrapper.getResult());
	}
}

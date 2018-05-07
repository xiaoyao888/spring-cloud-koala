package com.xingling.cloud.web.controller;

import com.xingling.cloud.dto.UserDto;
import com.xingling.cloud.model.domain.Log;
import com.xingling.cloud.service.LogService;
import com.xingling.controller.BaseController;
import com.xingling.vo.Page;
import com.xingling.wrap.WrapMapper;
import com.xingling.wrap.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>Title:	  UserController. </p>
 * <p>Description 用户controller </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate 2017 /8/17 19:05
 */
@RestController
@RequestMapping(value = "/log", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "LogController", tags = "LogController", description = "日志controller", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LogController extends BaseController{

	@Autowired
	private DiscoveryClient discoveryClient;


	@Resource
	private LogService logService;


	/**
	 * <p>Title:      queryUserInfoByUserName. </p>
	 * <p>Description 使用ribbon的方式调用</p>
	 *
	 * @param userName the user name
	 * @return user wrapper
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /11/6 17:54
	 */
	@GetMapping("/queryUserInfoByUserName/{userName}")
	@ApiOperation(notes = "使用ribbon的方式调用", httpMethod = "GET", value = "使用ribbon的方式调用")
	public UserDto queryUserInfoByUserName(@PathVariable("userName") String userName) {
		UserDto user = logService.queryUserInfoByUserName(userName);
		return user;
	}

	/**
	 * <p>Title:	  showInfo. </p>
	 * <p>Description 本地服务实例的信息</p>
	 *
	 * @return the service instance
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @CreateDate 2017 /8/17 19:05
	 */
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}

	/**
	 * <p>Title:      saveLog. </p>
	 * <p>Description 保存日志</p>
	 *
	 * @param log the log
	 * @return wrapper wrapper
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2018 /1/4 15:11
	 */
	@PostMapping("saveLog")
	@ApiOperation(notes = "保存日志", httpMethod = "POST", value = "保存日志")
	@ApiImplicitParam(name = "log", value = "分页查询日志", required = true, dataType = "Log")
	public Wrapper<?> saveLog(@RequestBody Log log) {
		logService.saveLog(log);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE);
	}

	/**
	 * <p>Title:      listPage. </p>
	 * <p>Description 分页查询日志</p>
	 *
	 * @return wrapper wrapper
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2018 /1/4 15:11
	 */
	@PostMapping("listPage")
	@ApiOperation(notes = "分页查询日志", httpMethod = "POST", value = "分页查询日志")
	public Wrapper<?> listPage() {
		Page listPage = logService.listPage(1, 10);
		return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE,listPage);
	}
}

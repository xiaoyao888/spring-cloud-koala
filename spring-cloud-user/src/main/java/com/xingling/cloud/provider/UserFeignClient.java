package com.xingling.cloud.provider;

import com.xingling.cloud.dto.UserDto;
import com.xingling.cloud.model.domain.User;
import com.xingling.cloud.service.UserFeignClientApi;
import com.xingling.cloud.service.UserService;
import com.xingling.wrap.WrapMapper;
import com.xingling.wrap.Wrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Title:	  spring-cloud-koala <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.hnxianyi.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2018/1/7 18:27
 */
@RefreshScope
@RestController
@Api(value = "FeignClient-用户信息接口", description = "用户信息接口", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserFeignClient implements UserFeignClientApi{

    @Resource
    private UserService userService;

    @Override
    public Wrapper<UserDto> queryUserByUserName(@PathVariable("userName") String userName) {
        User user = new User();
        user.setUserName(userName);
        User us = this.userService.selectOne(user);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(us,userDto);
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, userDto);
    }
}

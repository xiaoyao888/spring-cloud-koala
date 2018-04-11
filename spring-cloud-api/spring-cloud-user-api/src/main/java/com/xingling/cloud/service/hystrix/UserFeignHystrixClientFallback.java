package com.xingling.cloud.service.hystrix;

import com.xingling.cloud.dto.UserDto;
import com.xingling.cloud.service.UserFeignClientApi;
import com.xingling.wrap.WrapMapper;
import com.xingling.wrap.Wrapper;
import org.springframework.stereotype.Component;

/**
 * <p>Title:	  spring-cloud-koala <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2018/1/6 18:22
 */
@Component
public class UserFeignHystrixClientFallback implements UserFeignClientApi{
    @Override
    public Wrapper<UserDto> queryUserByUserName(String userName) {
        UserDto userDto = new UserDto();
        userDto.setUserName("超级管理员");
        userDto.setRealName("超级管理员");
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, userDto);
    }
}

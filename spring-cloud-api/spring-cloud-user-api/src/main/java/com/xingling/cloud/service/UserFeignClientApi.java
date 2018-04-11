package com.xingling.cloud.service;

import com.xingling.cloud.dto.UserDto;
import com.xingling.cloud.service.hystrix.UserFeignHystrixClientFallback;
import com.xingling.wrap.Wrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Title:	  spring-cloud-koala <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.hnxianyi.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2018/1/7 17:55
 */
@FeignClient(name = "spring-cloud-provider-user",fallback = UserFeignHystrixClientFallback.class)
public interface UserFeignClientApi {

    /**
     * <p>Title:	  getUser. </p>
     * <p>Description 查询用户信息</p>
     *
     * @param userName String
     * @return the user
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @CreateDate 2017 /8/17 19:04
     */
    @RequestMapping(value = "/api/user/queryUserByUserName/{userName}", method = RequestMethod.POST)
    Wrapper<UserDto> queryUserByUserName(@PathVariable("userName") String userName);
}

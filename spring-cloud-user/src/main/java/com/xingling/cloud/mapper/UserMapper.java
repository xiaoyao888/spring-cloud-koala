package com.xingling.cloud.mapper;


import com.xingling.cloud.model.domain.User;
import com.xingling.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Title:	  koala-umc <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017 /5/15 13:50
 */
@Mapper
@Component
public interface UserMapper extends MyMapper<User> {

    /**
     * Load user by username user.
     *
     * @param userName the user name
     * @return the user
     */
    User loadUserByUsername(String userName);

    /**
     * <p>Title:      分页查询用户信息. </p>
     * <p>Description </p>
     *
     * @param user the user
     * @return page info
     * @Author <a href="yangwensheng@meicai.cn"/>杨文生</a>
     * @since 2018 /2/9 12:09
     */
    List<User> queryListPage(User user);
}

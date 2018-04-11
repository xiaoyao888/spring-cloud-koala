package com.xingling.cloud.service;

import com.xingling.cloud.model.domain.Authority;
import com.xingling.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>Title:      AuthorityService. </p>
 * <p>Description TODO </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2018 /1/16 14:50
 */
public interface AuthorityService extends BaseService<Authority> {

    /**
     * <p>Title:      getOwnAuthority. </p>
     * <p>Description 根据userId查询拥有的权限</p>
     *
     * @param userId the user id
     * @return own authority
     * @Author <a href="yangwensheng@meicai.cn"/>杨文生</a>
     * @since 2018 /1/16 15:24
     */
    List<Authority> getOwnAuthority(String userId);
}
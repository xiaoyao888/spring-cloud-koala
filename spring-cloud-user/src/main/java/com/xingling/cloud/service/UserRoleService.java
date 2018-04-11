package com.xingling.cloud.service;

import com.xingling.cloud.model.domain.UserRole;
import com.xingling.service.mybatis.BaseService;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * <p>Title:      UserRoleService. </p>
 * <p>Description TODO </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author <a href="190332447@qq.com"/>杨文生</a>
 * @since 2018 /1/16 14:50
 */
public interface UserRoleService extends BaseService<UserRole> {

    /**
     * <p>Title:      loadUserAuthorities. </p>
     * <p>Description 根据userId查询拥有的权限</p>
     *
     * @param userId the user id
     * @return own authority
     * @Author <a href="yangwensheng@meicai.cn"/>杨文生</a>
     * @since 2018 /1/16 15:24
     */
    Collection<GrantedAuthority> loadUserAuthorities(String userId);

    /**
     * <p>Title:      queryOwnRoles. </p>
     * <p>Description 根据userId查询拥有的角色信息</p>
     *
     * @param query the query
     * @return list
     * @Author <a href="yangwensheng@meicai.cn"/>杨文生</a>
     * @since 2018 /2/8 14:50
     */
    List<com.xingling.dto.RoleDto> queryOwnRoles(UserRole query);
}
package com.xingling.cloud.service.impl;

import com.google.common.collect.Lists;
import com.xingling.cloud.mapper.UserRoleMapper;
import com.xingling.cloud.model.domain.Authority;
import com.xingling.cloud.model.domain.User;
import com.xingling.cloud.model.domain.UserRole;
import com.xingling.cloud.service.AuthorityService;
import com.xingling.cloud.service.UserRoleService;
import com.xingling.dto.RoleDto;
import com.xingling.service.mybatis.impl.BaseServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * <p>Title:	  UserRoleServiceImpl <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2018/1/16 14:45
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Resource
    private AuthorityService authorityService;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public Collection<GrantedAuthority> loadUserAuthorities(String userId) {
        List<Authority> ownAuthList = authorityService.getOwnAuthority(userId);
        List<GrantedAuthority> authList = Lists.newArrayList();
        for (Authority authority : ownAuthList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthorityCode());
            authList.add(grantedAuthority);
        }
        return authList;
    }

    @Override
    public List<RoleDto> queryOwnRoles(UserRole query) {
        return userRoleMapper.queryOwnRoles(query);
    }

    @Override
    public List<User> getBindUserByRoleId(String roleId) {
        return userRoleMapper.getBindUserByRoleId(roleId);
    }
}

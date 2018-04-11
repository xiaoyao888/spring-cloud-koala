package com.xingling.cloud.service;

import com.xingling.cloud.model.domain.Role;
import com.xingling.dto.AuthUserDto;
import com.xingling.service.mybatis.BaseService;

import java.util.List;

/**
 * <p>Title:      RoleService. </p>
 * <p>Description TODO </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @author         <a href="190332447@qq.com"/>杨文生</a>
 * @since      2018/1/16 14:50
 */
public interface RoleService extends BaseService<Role> {

    List<Role> queryListPage(Role role);

    int deleteRoleById(String id, AuthUserDto authUserDto);

    int enableRoleById(String id, AuthUserDto authUserDto);

    int disableRoleById(String id, AuthUserDto authUserDto);

    int modifyRole(Role role, AuthUserDto authUserDto);

    int saveRoleInfo(Role role, AuthUserDto authUserDto);
}
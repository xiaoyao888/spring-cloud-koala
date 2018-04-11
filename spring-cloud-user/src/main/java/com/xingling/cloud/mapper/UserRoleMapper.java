package com.xingling.cloud.mapper;

import com.xingling.cloud.model.domain.UserRole;
import com.xingling.dto.RoleDto;
import com.xingling.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserRoleMapper extends MyMapper<UserRole> {

    /**
     * <p>Title:      queryOwnRoles. </p>
     * <p>Description 根据userId查询拥有的角色信息</p>
     *
     * @param query the query
     * @return list
     * @Author <a href="yangwensheng@meicai.cn"/>杨文生</a>
     * @since 2018 /2/8 14:50
     */
    List<RoleDto> queryOwnRoles(UserRole query);
}
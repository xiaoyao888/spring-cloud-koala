package com.xingling.cloud.mapper;

import com.xingling.cloud.model.domain.Role;
import com.xingling.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMapper extends MyMapper<Role> {

    List<Role> queryListPage(Role role);
}
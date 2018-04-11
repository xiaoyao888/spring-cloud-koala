package com.xingling.cloud.mapper;

import com.xingling.cloud.model.domain.RoleAuthority;
import com.xingling.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleAuthorityMapper extends MyMapper<RoleAuthority> {

}
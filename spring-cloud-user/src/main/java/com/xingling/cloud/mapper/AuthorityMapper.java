package com.xingling.cloud.mapper;

import com.xingling.cloud.model.domain.Authority;
import com.xingling.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AuthorityMapper extends MyMapper<Authority> {

    List<Authority> getOwnAuthority(String userId);
}
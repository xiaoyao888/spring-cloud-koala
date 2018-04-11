package com.xingling.cloud.mapper;

import com.xingling.cloud.model.domain.Menu;
import com.xingling.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MenuMapper extends MyMapper<Menu> {

}
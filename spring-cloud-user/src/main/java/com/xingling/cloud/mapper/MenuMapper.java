package com.xingling.cloud.mapper;

import com.xingling.cloud.model.domain.Menu;
import com.xingling.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Menu mapper.
 */
@Mapper
@Component
public interface MenuMapper extends MyMapper<Menu> {


    /**
     * Select all menu list.
     *
     * @return the list
     */
    List<Menu> selectAllMenu();
}
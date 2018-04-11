package com.xingling.dao;

import com.xingling.vo.Page;
import org.springframework.data.mongodb.core.query.Update;


public interface BaseDao<T> {

    boolean remove(String id);

    T  get(String id);

    void insert(T t);

    boolean update(Update update, String id) ;

    Page listPage(Integer pageNum, Integer pageSize);

}

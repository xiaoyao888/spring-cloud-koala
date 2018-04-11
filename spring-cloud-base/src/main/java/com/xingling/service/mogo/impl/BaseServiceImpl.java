package com.xingling.service.mogo.impl;

import com.xingling.dao.BaseDao;
import com.xingling.service.mogo.BaseService;
import com.xingling.vo.Page;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public  class BaseServiceImpl<T> implements BaseService<T> {

	@Resource
	private BaseDao baseDao;

	@Override
	public T get(String id) {
		return (T) baseDao.get(id);
	}

	@Override
	public boolean remove(String id) {
		return baseDao.remove(id);
	}

	@Override
	public void insert(T record) {
		baseDao.insert(record);
	}

	@Override
	public boolean update(Update update, String id) {
		return baseDao.update(update,id);
	}

	@Override
	public Page listPage(Integer pageNum, Integer pageSize) {
		return baseDao.listPage(pageNum,pageSize);
	}


}

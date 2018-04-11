package com.xingling.service.mybatis.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingling.service.mybatis.BaseService;
import com.xingling.vo.PageQuery;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected Mapper<T> mapper;

	public Mapper<T> getMapper() {
        return mapper;
    }
	
	@Override
	public List<T> select(T record) {
		return mapper.select(record);
	}

	@Override
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}

	@Override
	public int selectCount(T record) {
		return mapper.selectCount(record);
	}

	@Override
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	@Override
	public int save(T record) {
		return mapper.insertSelective(record);
	}

    @Override
    public int batchSave(List<T> list) {
        int result = 0;
        for (T record : list) {
            int count = mapper.insertSelective(record);
            if(count < 1){
                throw new RuntimeException("插入数据失败!");
            }
            result += count;
        }
        return result;
    }

    @Override
	public int update(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int delete(T record) {
		return mapper.delete(record);
	}

	@Override
	public int deleteByKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}
	
	@Override
	public int batchDelete(List<T> list) {
		int result = 0;
		for (T record : list) {
			int count = mapper.delete(record);
			if(count < 1){
				throw new RuntimeException("插入数据失败!");
			}
			result += count;
		}
		return result;
	}

	@Override
	public int selectCountByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	@Override
	public int updateByExample(T record, Object example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int deleteByExample(Object example) {
		return mapper.deleteByPrimaryKey(example);
	}

	@Override
	public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
		return mapper.selectByRowBounds(record, rowBounds);
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		return mapper.selectByExampleAndRowBounds(example, rowBounds);
	}

	@Override
	public PageInfo<T> listPage(PageQuery query) {
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Example example = new Example(clazz);
		if(query.entrySet().size()>0) {
			Example.Criteria criteria = example.createCriteria();
			for (Map.Entry<String, Object> entry : query.entrySet()) {
				criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
			}
		}
		PageHelper.startPage(query.getNumber(), query.getSize());
		List<T> list = mapper.selectByExample(example);
		PageInfo<T> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
}

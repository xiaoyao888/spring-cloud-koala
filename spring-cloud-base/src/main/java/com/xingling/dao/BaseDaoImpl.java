package com.xingling.dao;

import com.mongodb.WriteResult;
import com.xingling.constant.Constants;
import com.xingling.vo.Page;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建一个 Class 的对象来获取泛型的 Class
     */
    private Class<T> clz;


    public Class<T> getClz(){
        if(clz==null){
            clz = ((Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        }
        return clz;
    }



    @Override
    public boolean remove(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        WriteResult writeResult =  mongoTemplate.remove(query, getClz());
        return  writeResult.getN() > 0 ? true :false;
    }

    @Override
    public T get(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query,getClz());
    }

    @Override
    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    @Override
    public boolean update(Update update,String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Query query = new Query(criteria);
        WriteResult writeResult =mongoTemplate.updateFirst(query,update,getClz());
        return  writeResult.getN() > 0 ? true :false;
    }

    @Override
    public Page listPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum==null ? Constants.DEFAULT_PAGE_NUM: pageNum;
        pageSize = pageSize==null ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Query query = new Query();
        long totalCount = mongoTemplate.count(query,getClz());
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<T> list = mongoTemplate.find(query,getClz());
        Page page = new Page(pageNum,pageSize);
        page.setListData(list);
        page.setPageCount(totalCount);
        return page;
    }
}

package com.xingling.cloud.dao.impl;


import com.xingling.cloud.dao.LogDao;
import com.xingling.cloud.model.domain.Log;
import com.xingling.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>Title:	  koala-umc <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017/5/15 13:50
 */
@Repository("logDao")
public class LogDaoImpl extends BaseDaoImpl<Log> implements LogDao{
}

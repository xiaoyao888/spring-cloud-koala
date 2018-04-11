package com.xingling.cloud.service.impl;

import com.xingling.cloud.dao.LogDao;
import com.xingling.cloud.dto.UserDto;
import com.xingling.cloud.model.domain.Log;
import com.xingling.cloud.service.LogService;
import com.xingling.service.mogo.impl.BaseServiceImpl;
import com.xingling.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>Title:	  koala-umc <br/> </p>
 * <p>Description TODO <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017/5/15 13:50
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {

	@Autowired
	private RestTemplate restTemplate;

	@Resource
	private LogDao logDao;

	@Override
	public UserDto queryUserInfoByUserName(String userName) {
		return this.restTemplate.getForObject("http://spring-cloud-provider-user/user/queryUserByUserName/" + userName, UserDto.class);
	}

	@Override
	public Log getLog(String id) {
		return logDao.get(id);
	}

	@Override
	public boolean removeLog(String id) {
		return logDao.remove(id);
	}

	@Override
	public void saveLog(Log log) {
		logDao.insert(log);
	}

	@Override
	public boolean updateLog(Log log) {
		Update update = new Update();
		update.set("browser",log.getBrowser());
		return  logDao.update(update,log.getId());
	}

	@Override
	public Page listPage(Integer pageNum, Integer pageSize) {
		return logDao.listPage(pageNum,pageSize);
	}
}

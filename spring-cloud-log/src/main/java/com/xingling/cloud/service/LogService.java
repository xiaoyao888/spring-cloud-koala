package com.xingling.cloud.service;

import com.xingling.cloud.dto.UserDto;
import com.xingling.cloud.model.domain.Log;
import com.xingling.service.mogo.BaseService;
import com.xingling.vo.Page;
import org.springframework.stereotype.Service;

/**
 * <p>Title:	  UserService <br/> </p>
 * <p>Description 用户service <br/> </p>
 * <p>Company:    http://www.xinglinglove.com  <br/> </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>  <br/>
 * @Date 2017 /5/15 13:49
 */
@Service
public interface LogService extends BaseService<Log> {

	/**
	 * <p>Title:      queryUserInfoByUserName. </p>
	 * <p>Description 根据用户名查询用户信息</p>
	 *
	 * @param userName the user name
	 * @return user user dto
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /11/6 17:44
	 */
	UserDto queryUserInfoByUserName(String userName);

	/**
	 * <p>Title:      getLog. </p>
	 * <p>Description 查询日志信息</p>
	 *
	 * @param id the id
	 * @return log
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /12/30 11:31
	 */
	Log getLog(String id);

	/**
	 * <p>Title:      removeLog. </p>
	 * <p>Description 删错日志信息</p>
	 *
	 * @param id the id
	 * @return boolean
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /12/30 11:31
	 */
	boolean removeLog(String id);

	/**
	 * <p>Title:      saveLog. </p>
	 * <p>Description 保存日志信息</p>
	 *
	 * @param log the log
	 * @return
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /12/30 11:31
	 */
	void saveLog(Log log);

	/**
	 * <p>Title:      updateLog. </p>
	 * <p>Description 更新日志信息</p>
	 *
	 * @param log the log
	 * @return boolean
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /12/30 11:31
	 */
	boolean updateLog(Log log);

	/**
	 * <p>Title:      listPage. </p>
	 * <p>Description 分页查询日志信息</p>
	 *
	 * @param pageNum  the page num
	 * @param pageSize the page size
	 * @return page
	 * @Author <a href="190332447@qq.com"/>杨文生</a>
	 * @since 2017 /12/30 11:31
	 */
	Page listPage(Integer pageNum, Integer pageSize);
}

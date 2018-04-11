package com.xingling.service.mogo;

import com.xingling.vo.Page;
import org.springframework.data.mongodb.core.query.Update;

/**
 * <p>Title:	  BaseService. </p>
 * <p>Description 通用接口 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @param <T> the type parameter
 * @Author <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate 2017 /4/21 12:37
 */
public interface BaseService<T> {

    /**
     * <p>Title:      get. </p>
     * <p>Description 查询日志信息</p>
     *
     * @param id the id
     * @return log t
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2017 /12/30 11:31
     */
    T get(String id);

    /**
     * <p>Title:      remove. </p>
     * <p>Description 删错日志信息</p>
     *
     * @param id the id
     * @return boolean boolean
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2017 /12/30 11:31
     */
    boolean remove(String id);

    /**
     * <p>Title:      insert. </p>
     * <p>Description 保存日志信息</p>
     *
     * @param record the record
     * @return
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2017 /12/30 11:31
     */
    void insert(T record);

    /**
     * <p>Title:      update. </p>
     * <p>Description 更新日志信息</p>
     *
     * @param update the update
     * @param id     the id
     * @return boolean boolean
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2017 /12/30 11:31
     */
    boolean update(Update update,String id);

    /**
     * <p>Title:      listPage. </p>
     * <p>Description 分页查询日志信息</p>
     *
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return page page
     * @Author <a href="190332447@qq.com"/>杨文生</a>
     * @since 2017 /12/30 11:31
     */
    Page listPage(Integer pageNum, Integer pageSize);
}

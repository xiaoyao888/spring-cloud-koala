package com.xingling.vo;

import io.swagger.annotations.ApiModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
/**
 * <p>Title:	  Page. </p>
 * <p>Description 分页对象 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/8/18 13:45
 */
@ApiModel(value = "mongo分页dto")
public class Page extends PageRequest {

    public Page(int page, int size) {
        super(page, size);
    }

    private List<?> listData;//实体封装数据

    // 数据
    private List<Map<String, Object>> results;

    public List<Map<String, Object>> getResults() {

        return this.results;
    }

    public void setResults(List<Map<String, Object>> results) {

        this.results = results;
    }


    public List<?> getListData() {
        return this.listData;
    }

    public void setListData(List<?> listData) {
        this.listData = listData;
    }

    // 总页数
    private Long pageCount = 0L;
    // 总条数
    private Long totalCount = 0L;

    public Long getPageCount() {

        return this.pageCount;
    }

    public void setPageCount(Long pageCount) {

        this.pageCount = pageCount;
    }

    public Long getTotalCount() {

        return this.totalCount;
    }

    public void setTotalCount(Long totalCount) {

        this.totalCount = totalCount;
    }
}
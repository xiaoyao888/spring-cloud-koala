package com.xingling.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * <p>Title:	  PageQuery. </p>
 * <p>Description 分页查询参数 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/8/18 13:45
 */
@Data
@ApiModel(value = "分页dto")
public class PageQuery extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	//当前页码
    @ApiModelProperty(value = "当前页码")
    private int number = 1;

    //每页条数
    @ApiModelProperty(value = "每页条数")
    private int size = 10;

    public PageQuery(Map<String, Object> params){
        this.putAll(params);
        //分页参数
        if(params.get("number")!=null) {
            this.number = Integer.parseInt(params.get("number").toString());
        }
        if(params.get("size")!=null) {
            this.size = Integer.parseInt(params.get("size").toString());
        }
        this.remove("number");
        this.remove("size");
    }
}

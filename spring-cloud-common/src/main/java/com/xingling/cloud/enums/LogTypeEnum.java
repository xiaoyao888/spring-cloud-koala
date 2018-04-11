package com.xingling.cloud.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:	  LogTypeEnum. </p>
 * <p>Description 日志类型 </p>
 * <p>Company:    http://www.xinglinglove.com </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate 2017/4/19 11:31
 */
public enum LogTypeEnum {
    /**
     * 操作日志
     */
    OPERATION_LOG("10", "操作日志"),
    /**
     * 登录日志
     */
    LOGIN_LOG("20", "登录日志"),
    /**
     * 异常日志
     */
    EXCEPTION_LOG("30", "异常日志");

    String type;
    String name;

    LogTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String type) {
        for (LogTypeEnum ele : LogTypeEnum.values()) {
            if (ele.getType().equals(type))
                return ele.getName();
        }
        return null;
    }

    public static LogTypeEnum getEnum(String type) {
        for (LogTypeEnum ele : LogTypeEnum.values()) {
            if (ele.getType().equalsIgnoreCase(type))
                return ele;
        }
        return LogTypeEnum.OPERATION_LOG;
    }

    public static List<Map<String, Object>> getList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (LogTypeEnum ele : LogTypeEnum.values()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("key", ele.getType());
            map.put("value", ele.getName());
            list.add(map);
        }
        return list;
    }

}

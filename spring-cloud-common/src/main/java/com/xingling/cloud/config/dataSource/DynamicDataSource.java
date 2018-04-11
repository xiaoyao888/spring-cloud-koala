package com.xingling.cloud.config.dataSource;

import com.xingling.cloud.enums.DatabaseType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title:      DynamicDataSource. </p>
 * <p>Description 使用DatabaseContextHolder获取当前线程的DatabaseType </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:    xinglinglove </p>
 *
 * @author         <a href="yangwensheng@meicai.cn"/>杨文生</a>
 * @since      2018/1/29 12:04
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    public static final Map<DatabaseType, List<String>> METHOD_TYPE_MAP = new HashMap<>();


    @Override
    protected Object determineCurrentLookupKey() {
        DatabaseType type = DatabaseContextHolder.getDatabaseType();
        logger.info("====================dataSource ==========" + type);
        return type;
    }

    void setMethodType(DatabaseType type, String content) {
        List<String> list = Arrays.asList(content.split(","));
        METHOD_TYPE_MAP.put(type, list);
    }
}

package com.example.demo.config.datasource.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leikai
 * @version 2019/4/26
 */
public class DruidDataSourceUtil {
    public static DruidDataSource getMysqlDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        List<Filter> filters = new ArrayList<>();
        filters.add(wallFilter());
        filters.add(statFilter());
        druidDataSource.setProxyFilters(filters);
        druidDataSource.setValidationQuery("select 'x'");
        return druidDataSource;
    }

    public static WallFilter wallFilter(){
        WallFilter wall = new WallFilter();
        wall.setConfig(wallConfig());
        return wall;
    }

    public static StatFilter statFilter() {
        return new StatFilter();
    }

    public static WallConfig wallConfig(){
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);
        return wallConfig;
    }
}

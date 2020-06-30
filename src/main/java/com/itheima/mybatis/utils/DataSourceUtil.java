package com.itheima.mybatis.utils;

import com.itheima.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * auther:XingTL
 * date:2020/5/8 15:23
 */

/**
 * 用于创建数据源的工具类
 */
public class DataSourceUtil {
    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        Connection connection = null;
        try {
            Class.forName(cfg.getDriver());
            connection =  DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

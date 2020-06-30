package com.itheima.mybatis.sqlsession;

/**
 * auther:XingTL
 * date:2020/5/8 14:29
 */
public interface SqlSessionFactory {
    //用于打开一个新的sqlsession对象
    SqlSession openSession();
}

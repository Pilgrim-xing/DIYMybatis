package com.itheima;

/**
 * auther:XingTL
 * date:2020/6/30 18:23
 */

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.sqlsession.SqlSession;
import com.itheima.mybatis.sqlsession.SqlSessionFactory;
import com.itheima.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 自定义Mybatis实现
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        //2.创建SqlSessionFactory工厂
        //3.使用工厂生产SqlSession对象
        //4.使用SqlSession创建Dao接口的代理对象
        //5.使用代理对象执行方法
        //6.释放资源

        //1
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3
        SqlSession session = factory.openSession();
        //4
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6
        session.close();
        in.close();
    }
}

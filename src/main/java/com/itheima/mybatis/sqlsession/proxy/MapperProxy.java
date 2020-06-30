package com.itheima.mybatis.sqlsession.proxy;

import com.itheima.mybatis.cfg.Mapper;
import com.itheima.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * auther:XingTL
 * date:2020/5/8 15:12
 */
public class MapperProxy implements InvocationHandler {
    //map.key 是全限定类名+方法名
    private Map<String,Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用来对方法进行增强  我们的增强其实就是调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className + "."+methodName ;
        //4.获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        //5.判断是否有mapper
        if(mapper == null){
            //传参有问题
            throw new IllegalArgumentException("传参有误");
        }
        //6.调用工具类，执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}

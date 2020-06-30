package com.itheima.dao;

/**
 * auther:XingTL
 * date:2020/4/28 21:35
 */

import com.itheima.domain.User;
import com.itheima.mybatis.annotations.Select;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}

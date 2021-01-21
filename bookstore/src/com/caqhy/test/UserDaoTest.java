package com.caqhy.test;

import com.caqhy.dao.UserDao;
import com.caqhy.dao.impl.UserDaoImpl;
import com.caqhy.pojo.User;
import com.caqhy.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;


public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        Connection conn = JdbcUtils.getConnection();

        if (userDao.queryUserByUsername(conn,"admin1234") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        Connection conn = JdbcUtils.getConnection();
        if ( userDao.queryUserByUsernameAndPassword(conn,"admin","admin1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println( userDao.saveUser(conn,new User(null,"wzg168", "123456", "wzg168@qq.com")) );
    }
}
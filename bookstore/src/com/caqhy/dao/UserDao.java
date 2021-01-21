package com.caqhy.dao;

import com.caqhy.pojo.User;

import java.sql.Connection;

public interface UserDao {

    User queryUserByUsername(Connection conn, String username);


    User queryUserByUsernameAndPassword(Connection conn, String username, String password);


    int saveUser(Connection conn, User user);
}

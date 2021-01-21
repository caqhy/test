package com.caqhy.dao.impl;

import com.caqhy.dao.UserDao;
import com.caqhy.pojo.User;

import java.sql.Connection;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryUserByUsername(Connection conn, String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(conn, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(Connection conn, String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(conn, sql, username, password);
    }

    @Override
    public int saveUser(Connection conn, User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(conn, sql, user.getUsername(),user.getPassword(),user.getEmail());
    }
}

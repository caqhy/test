package com.caqhy.service;

import com.caqhy.pojo.User;

public interface UserService {

    void registUser(User user);
    User login(User user);
    Boolean existsUsername(String username);

}

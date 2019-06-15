package com.example.basic.design.proxy.cglib;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/28
 */
public interface UserBiz {
    void addUser(String username, String passworld);

    void delUser(int id);
}

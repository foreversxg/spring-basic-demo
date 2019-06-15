package com.example.basic.design.proxy.cglib;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/5/28
 */
public class UserBizImpl implements UserBiz {
    @Override
    public void addUser(String username, String passworld) {
        System.out.println(username+"用户添加成功");
    }

    @Override
    public void delUser(int id) {
        System.out.println("编号为"+id+"的用户被删除");
    }
}

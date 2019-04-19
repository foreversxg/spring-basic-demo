package com.example.basic.design.proxy;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/19
 */
public class James implements HouseBuyer {

    @Override
    public void pay() {
        System.out.println("james pay for the house");
    }
}

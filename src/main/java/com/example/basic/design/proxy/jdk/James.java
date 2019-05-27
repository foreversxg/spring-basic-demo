package com.example.basic.design.proxy.jdk;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/19
 */
public class James implements HouseBuyer {

    private String name;

    @Override
    public void pay(int num) {
//        System.out.println("james pay for the house:" + num);
        num ++;
    }

    private void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

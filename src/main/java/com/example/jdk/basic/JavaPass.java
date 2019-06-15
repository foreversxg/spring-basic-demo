package com.example.jdk.basic;

import java.util.List;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/15
 */
public class JavaPass {

    public static void main(String[] args) {
        new JavaPass().test_Object_type_pass_2();
    }

    public void test_basic_type_pass() {

        int a =1;
        changeBasic(a);
        System.out.println("test_basic_type_pass：" + a);
    }

    public void test_Object_type_pass_1() {
        Person person = new Person();
        person.name = "tom";
        changeObject(person);
        System.out.println("test_Object_type_pass_1：" + person.name);

    }

    public void test_Object_type_pass_2() {
        Person person = new Person();
        person.name = "tom";
        changeObject2(person);
        System.out.println("test_Object_type_pass_2：" + person.name);

    }

    private void changeObject2(Person person) {
        person = new Person();
        person.name = "jim";
        System.out.println("changeObject：" + person.name);
    }

    private void changeObject(Person person) {
        person.name = "jim";
        System.out.println("changeObject：" + person.name);

    }

    private void changeBasic(int a) {
        a ++;
        System.out.println("changeBasic：" + a);
    }

    public static class Person{

        String name;
    }


}

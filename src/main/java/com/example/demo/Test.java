package com.example.demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/11/20
 */
public class Test {

    public static void main(String[] args) {
        int n =7;
        if(n%1==0 || n%n==0) {
            if(n%2==0 || n%3 == 0) {
                System.out.println("not");
            } else {
                System.out.println("yes");
            }
        }
    }
    public static class RocketMQListenerImpl implements RocketMQListener<String> {

        @Override
        public void onMessage(String message) {

        }
    }


    private Class getMessageType(RocketMQListener rocketMQListener) {
        Type[] interfaces = rocketMQListener.getClass().getGenericInterfaces();
        if (Objects.nonNull(interfaces)) {
            for (Type type : interfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (Objects.equals(parameterizedType.getRawType(), RocketMQListener.class)) {
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        if (Objects.nonNull(actualTypeArguments) && actualTypeArguments.length > 0) {
                            return (Class) actualTypeArguments[0];
                        } else {
                            return Object.class;
                        }
                    }
                }
            }

            return Object.class;
        } else {
            return Object.class;
        }
    }
}

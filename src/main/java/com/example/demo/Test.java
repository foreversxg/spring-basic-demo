package com.example.demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/11/20
 */
public class Test {

    static Character[] chars = {'0','1','2','3','4','5','6','7','8','9'};
    static List<Character> list = Arrays.asList(chars);


    public static void main(String[] args) {
        System.out.println(calc("1233434433443343434","1234343344344"));
    }

    public static String calc(String str1,String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int aLen = a.length - 1;
        int bLen = b.length - 1;
        int temp = 0;
        while (aLen >= 0 && bLen >= 0) {
            int aIndex = list.indexOf(a[aLen]);
            int bIndex = list.indexOf(b[bLen]);
            int sum = aIndex + bIndex + temp;
            if (sum >= 10) {
                temp = 1;
                sb.append(list.get(sum % 10));
            } else {
                temp = 0;
                sb.append(list.get(sum));
            }
            aLen--;
            bLen--;
        }
        while (aLen >= 0) {
            int sum = temp + list.get(toInt(a[aLen]));
            if (sum >= 10) {
                temp = 1;
                sb.append(list.get(sum % 10));
            } else {
                temp = 0;
                sb.append(list.get(sum));
            }
            aLen--;
        }
        while (bLen >= 0) {
            int sum = temp + list.get(toInt(b[bLen]));


            if (sum >= 10) {
                temp = 1;
                sb.append(list.get(sum % 10));
            } else {
                temp = 0;
                sb.append(list.get(sum));
            }
            bLen--;
        }
        if (temp > 0) {
            sb.append(temp);
        }
        return sb.reverse().toString();
    }

    private static int toInt(char c){
        byte b =2;
        int a = new Character('1');

        return Integer.parseInt(String.valueOf(c));
    }
}

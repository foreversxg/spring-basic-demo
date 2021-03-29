package com.example.basic.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/4/3
 */
public class Calc36 {

    static Character[] chars = {'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static List<Character> list = Arrays.asList(chars);


    public static void main(String[] args) {
        System.out.println(calc("a", "b"));
    }

    public static String calc(String str1,String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int aLen = a.length - 1;
        int bLen = b.length - 1;
        int temp = 0;
        while (aLen >=0 && bLen >= 0) {
            int aIndex = list.indexOf(a[aLen]);
            int bIndex = list.indexOf(b[bLen]);
            int sum = aIndex + bIndex + temp;
            if(sum >= 36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp = 0;
                sb.append(list.get(sum));
            }
            aLen--;
            bLen--;
        }
        while (aLen >= 0) {
            int sum = temp + list.get(a[aLen]);
            if(sum >= 36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp = 0;
                sb.append(list.get(sum));
            }
            aLen --;
        }
        while(bLen >= 0 ){
            int sum = temp + list.get(b[bLen]);
            if(sum >= 36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp = 0;
                sb.append(list.get(sum));
            }
            bLen --;
        }
        if(temp > 0) {
            sb.append(temp);
        }
        return sb.reverse().toString();
    }

}

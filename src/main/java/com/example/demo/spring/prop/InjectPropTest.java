package com.example.demo.spring.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author shaoxiangen
 * @Date create in 2019/9/21
 */
@Service
public class InjectPropTest {

    @Value("word")
    private String word;

    public void say(){
        System.out.println(word);
    }

    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            for (int j = 0; j < i; j++) {
                System.out.println(values[j] + ":" + subSolutions[i- j - 1] );
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            }
            subSolutions[i] = tmpMax;
        }
        return subSolutions[rodLength];
    }

    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length;

        System.out.println("Max rod value: " + getValue(values, rodLength));
    }

}

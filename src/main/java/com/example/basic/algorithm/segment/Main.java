package com.example.basic.algorithm.segment;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shaoxiangen
 * @Date create in 2019/9/27
 */
public class Main {
    /**
     * [0,3,5,8]
     * 1:1
     */

    public static void run(int[] array) {
        if(ArrayUtils.isEmpty(array)) {
            return;
        }
        int segmentLength = array[array.length - 1];
        int arrayIndex = 1;
        List<Segment> resultList = new ArrayList<>();
        for(int i=1;i<=segmentLength;i++) {

        }
    }

    public static class Segment {
        private int index;
        private int singer;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getSinger() {
            return singer;
        }

        public void setSinger(int singer) {
            this.singer = singer;
        }
    }
}

package com.example.traffic;

import java.util.List;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/1/8
 */
public class ForkEntry extends Entry{

    private List<Entry> nexts;

    public List<Entry> getNexts() {
        return nexts;
    }

    public void setNexts(List<Entry> nexts) {
        this.nexts = nexts;
    }
}

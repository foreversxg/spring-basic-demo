package com.example.basic.design.proxy.chain;

import com.example.basic.structure.list.List;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/6/3
 */
public class FilterChain {

    private int index = -1;
    private List<Filter> filterList;
    private Object target;

    public FilterChain (List<Filter> filterList) {
        this.filterList = filterList;
    }

    public Object proceed(){

        if(index == filterList.size() -1) {
//            return target.
        }

        return null;
    }
}

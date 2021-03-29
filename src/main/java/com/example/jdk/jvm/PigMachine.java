package com.example.jdk.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxiangen
 * create in 2020/11/25
 */
public class PigMachine {

    private List<Food> foodCache = new ArrayList<>();

    public void eat() {
        foodCache.add(new Food());
    }

    public List<Food> getFoodCache() {
        return foodCache;
    }

    public void setFoodCache(List<Food> foodCache) {
        this.foodCache = foodCache;
    }
}

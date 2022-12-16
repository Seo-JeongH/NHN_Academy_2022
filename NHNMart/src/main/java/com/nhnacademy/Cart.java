package com.nhnacademy;

import java.util.ArrayList;

public class Cart {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public void print() {
        for(int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i));
        }
    }

    public ArrayList<Food> getFoods() {
        return this.foods;
    }
}

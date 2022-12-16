package com.nhnacademy;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food onion1) {
        foods.add(onion1);
    }

    public void getAll() { // 재고 전체 출력.
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i).getName() + " " + foods.get(i).getPrice());
        }
    }
    public ArrayList<Food> getFoods() {
        return this.foods;
    }

    public int getFoodsSize() {
        return foods.size();
    }

    public Food getFoodsValue(int i) {
        return foods.get(i);
    }

    public void delFoods(int i) {
        foods.remove(i);
    }

    public int getPrice(int i) {
        return foods.get(i).getPrice();
    }
    
}


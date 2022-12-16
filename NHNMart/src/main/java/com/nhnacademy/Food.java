package com.nhnacademy;

public class Food {
    private final String name;
    private final int price;

    private int count;
    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

//    public int getCount() {
//
//    }

    @Override
    public String toString() {
        return "com.nhnacademy.Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

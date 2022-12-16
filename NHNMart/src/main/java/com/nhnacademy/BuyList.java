package com.nhnacademy;

import java.util.ArrayList;

public class BuyList {
    private final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public int getItemsSize() {
        return items.size();
    }

    public String getItemsName(int i) {
//        for(int i = 0; i < items.size(); i++) {
//            items.get(i).name;
//        }
        return items.get(i).name;
    }

    public void getAll() {
        for(int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).name + " " + items.get(i).amount);
        }
    }

    public int getAmount(int i) {
        return items.get(i).amount;
    }

    public void delItems(int i) {
        items.remove(i);
    }

    public static class Item {
        private final String name;

        private final int amount;
        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }


    }
}

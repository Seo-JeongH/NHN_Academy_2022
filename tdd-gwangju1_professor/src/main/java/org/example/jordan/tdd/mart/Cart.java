package org.example.jordan.tdd.mart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {
    List<Goods> bag = new ArrayList<>(10);
    private int capacity = 0;

    public void addItem(Goods something) {
        this.capacity++;
        if (isOver()) {
            this.capacity--;
            throw new CartCapacityOverException();
        }
        bag.add(something);
    }

    private boolean isOver() {
        return capacity > 10;
    }

    public List<Goods> getAllItems() {
        return Collections.unmodifiableList(bag);
    }
}

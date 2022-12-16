package com.nhnacademy;

public class Counter {

    int onion;
    int egg;
    int Gonion;
    int apple;

    public Counter(int onion, int egg, int Gonion, int apple) {
        this.onion = onion;
        this.egg = egg;
        this.Gonion = Gonion;
        this.apple = apple;
    }

    int priceAll = 0;

    public int getPriceAll() {
        return this.priceAll;
    }

    public int getOnion() {
        return onion;
    }

    public int getEgg() {
        return egg;
    }

    public int getGonion() {
        return Gonion;
    }

    public int getApple() {
        return apple;
    }
}

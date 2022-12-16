package com.nhnacademy.gw1;

public class Customer {
    private Long customerId;
    private int point = 0;

    public Customer(Long customerId){
        this.customerId = customerId;

    }

    public int getPoint() {
        return point;
    }

    public void savePoint(int point) {
        this.point += point;
    }

    public void usePoint(int point){
        this.point -= point;
    }
}

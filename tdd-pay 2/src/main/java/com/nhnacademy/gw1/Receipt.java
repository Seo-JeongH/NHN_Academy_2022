package com.nhnacademy.gw1;

public class Receipt {
    private long amount;
    private long point;

    public Receipt() {
    }

    public Receipt(long amount){
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public long getPoint() {
        return point;
    }
}

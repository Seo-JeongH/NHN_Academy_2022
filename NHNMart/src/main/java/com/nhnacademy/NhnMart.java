package com.nhnacademy;

import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        System.out.println("현재 재고는 계란: 5개 / 양파: 2개 / 사과: 20개 / 파: 10개 있습니다.");
        BuyList buyList = inputBuyListFromShell();

//        Customer jordan = new Customer(buyList);

        // 체크용
//        jordan.getAllBuyList();
//        mart.getAllFoodStand();
        // 장바구니를 챙긴다.
//
//        jordan.bring(mart.provideBasket());
//        // 식품을 담는다.
//        jordan.pickFoods(mart.getFoodStand());
//        // 카운터에서 계산한다.
//        jordan.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // Scanner에서 buyList 만들기
        BuyList buyList = new BuyList();
//        buyList.add(new com.nhnacademy.BuyList.Item("파", 10));
//        buyList.add(new com.nhnacademy.BuyList.Item("사과", 5));
        Scanner sc = new Scanner(System.in);
//        buyList.add(new com.nhnacademy.BuyList.Item(sc.next(), sc.nextInt()));
//        buyList.add(new com.nhnacademy.BuyList.Item(sc.next(), sc.nextInt()));

        boolean tf = true;
        System.out.println(" {품목 개수} 형식으로 입력해서 엔터키를 누르시면 됩니다.");
        System.out.println("주문을 멈추고 싶으면 -1를 입력하세요.");
        while (tf) {
            String name = sc.next();
            if (name.equals("-1")) {
                tf = false;
            } else {
                int count = sc.nextInt();
                buyList.add(new BuyList.Item(name, count));
            }
        }

        // TODO
        return buyList;
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();

//    private Counter counter = new Counter();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) { //재고 2개
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) { //재고 5개
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {//재고 10개
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {//재고 20개
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Cart provideBasket() {
        return new Cart();
    }

    public FoodStand getFoodStand() {
        return foodStand;
    }

    //재고 출력
    public void getAllFoodStand() {
        foodStand.getAll();
    }

//    public Counter getCounter() {
//        return counter;
//    }

}

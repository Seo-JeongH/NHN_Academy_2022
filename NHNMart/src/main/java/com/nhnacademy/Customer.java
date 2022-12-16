package com.nhnacademy;

public class Customer {

    private int money = 20000;
    private int price = 0;
    private Counter counter;
    // 고객의 구매 목록
//    private final BuyList buyList;
    // 고객의 장바구니
    private Cart cart;

//    public Customer(BuyList buyList) {
//        this.buyList = buyList;
//    }


    public int getMoney() {
        return money;
    }

    public int setMoney(int price) {
        return this.money - price;
    }

    public int getPrice() {
        return price;
    }

    // 장바구니를 챙김
    public void bring(Cart cart) {
        this.cart = cart;

    }

//    public void getAllBuyList() {
//        this.buyList.getAll();
//    }
//
//    //음식 고르기. foodStand에서 가져오기.
//    public void pickFoods(FoodStand foodStand) {
//        for (int i = 0; i < buyList.getItemsSize(); i++) {
//            int count = 0;
//            for (int j = 0; j < foodStand.getFoodsSize(); ) {
//                if (foodStand.getFoodsValue(j).getName().equals(buyList.getItemsName(i))) {
//                    cart.add(foodStand.getFoodsValue(j));
//                    if((price + foodStand.getPrice(j) > money)) {
//                        System.out.println("보유한 돈보다 많이 담아서 계산이 불가 할거 같다.");
//                        System.out.println("먼저 담으신 음식부터 계산해야겠다");
//                    } else {
//                        price += foodStand.getPrice(j);
//                    }
//
//                    foodStand.delFoods(j);
//                    count++;
//                    j = 0;
//                    if (count == buyList.getAmount(i)) {
//                        break;
//                    }
//                } else {
//                    j++;
//                }
//
//            }
//        }
////        cart.print();
//    }


    //계산
    public void payTox(Counter counter) {
        counter.priceAll += this.price;
        System.out.println("총 가격은 " + counter.getPriceAll() + "입니다.");
        System.out.println("고객님 결제 후 잔액: " + (this.money - counter.getPriceAll()));
    }

}


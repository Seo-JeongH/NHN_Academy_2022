package com.nhnacademy.Exceptions;

//재고부족
public class AmountException extends Exception {
    public AmountException() {
    }

    public AmountException(String message) {
        super(message);
    }

    //사용법
//    public void divide(){
//        if(this.right == 0){
//            try {
//                throw new DivideException("0으로 나누는 것은 허용되지 않습니다.");
//            } catch (DivideException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.print(this.left/this.right);
//    }
}

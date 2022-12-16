package com.nhnacademy.gw1;

public class SmsService {

    public SmsService() {
    }

    public boolean doAlert(Receipt pay) {
         System.out.println("결제가 완료되었습니다.\n" + pay.getAmount()+"원");
        return true;
    }
}

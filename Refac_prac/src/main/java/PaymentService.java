public class PaymentService {

    public Discount getDiscount(long productAmt, String discountCode) {
        // 할인금액
        long discountAmt = 0;
        discountAmt = getDiscountAmt(productAmt, discountCode, discountAmt);
        return Discount.of(discountAmt);
    }

    private long getDiscountAmt(long productAmt, String discountCode, long discountAmt) {
        if ("NAVER".equals(discountCode)) {   // 네이버검색 할인
            discountAmt = (long) (productAmt * 0.1);
        } else if ("DANAWA".equals(discountCode)) { // 다나와검색 할인
            discountAmt = (long) (productAmt * 0.15);
        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페인입 할인
            if (productAmt < 1000)  // 할인쿠폰 금액보다 적은경우
                discountAmt = productAmt;
            else
                discountAmt = 1000;
        }
        return discountAmt;
    }

    public void payment(Customer customer, long productAmt, String discountCode) {
        // 결제금액
        long paymentAmt= productAmt - getDiscountAmt(productAmt, discountCode));
        if ("NAVER".equals(discountCode)) {   // 네이버검색 할인
            paymentAmt = (long) (productAmt * 0.9);
        } else if ("DANAWA".equals(discountCode)) { // 다나와검색 할인
            paymentAmt = (long) (productAmt * 0.85);
        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페인입 할인
            if (productAmt < 1000)  // 할인쿠폰 금액보다 적은경우
                paymentAmt = 0;
            else
                paymentAmt = productAmt - 1000;
        } else {
            paymentAmt = productAmt;
        }
        // TODO: 결제 처리...
    }
}
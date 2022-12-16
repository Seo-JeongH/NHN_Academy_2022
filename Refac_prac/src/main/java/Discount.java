public class Discount {

    private final long discountAmt;

    public Discount(long discountAmt) {
        this.discountAmt = discountAmt;
    }

    public long getDiscountAmt() {
        return discountAmt;
    }
    public static Discount of(long discountAmt) {
        return new Discount(discountAmt);
    }
}

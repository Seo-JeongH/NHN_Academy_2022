public interface Discountable {
    /** 할인없음 */
    Discountable NONE = new Discountable() {
        @Override
        public long getDiscountAmt(long originAmt) {
            return 0;
        }
    };

    long getDiscountAmt(long originAmt);
}
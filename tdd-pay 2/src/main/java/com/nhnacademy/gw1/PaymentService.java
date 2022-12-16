package com.nhnacademy.gw1;

public class PaymentService {
    private final CustomerRepository customerRepository;

    public PaymentService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private final long savePercent = 2L;
    private Receipt receipt;

    /**
     * 결제처리
     *
     * @param amount     결재 금액
     * @param customerId 고객 아이디
     * @return 영수증
     */
    public Receipt pay(long amount, Long customerId, int usePoint) {
        Receipt receipt = new Receipt();
        Customer customer = customerRepository.findById(customerId);
        SmsService smsService = new SmsService();
        if (customer == null) {
            throw new CustomerNotFoundException(customerId);
        }
        if(amount <0){
            throw new InvalidAmountException(amount);
        }
        if(customer.getPoint() > usePoint){
            pointPay(customer, usePoint);
            amount -= usePoint;
        }
        

        receipt.setAmount(amount);

        customer.savePoint((int) (amount * (0.01 * savePercent)));
        receipt.setPoint(customer.getPoint());
        smsService.doAlert(receipt);



        return receipt;
    }

    public void pointPay(Customer customer, int point) {
        customer.usePoint(point);
    }


}

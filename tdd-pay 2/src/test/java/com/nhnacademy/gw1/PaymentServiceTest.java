package com.nhnacademy.gw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceTest {
    // SUT

    PaymentService service;
    // DOC
    CustomerRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(CustomerRepository.class);

        service = new PaymentService(repository);
    }

    @Test
    void pay_notFoundCustomer_thenThrowCustomerNotFoundException() {
        long amount = 10_000L;
        Long customerId = 3423432L;

        when(repository.findById(customerId)).thenReturn(null);

        assertThatThrownBy(() -> service.pay(amount, customerId,0))
                .isInstanceOf(CustomerNotFoundException.class)
                .hasMessageContaining("Not found customer", customerId.toString());
    }

    @Test
    void pay_dependency_customer(){
        long amount = 10_000L;
        Long customerId = 3423432L;

        Customer customer = new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(null);

        assertThatThrownBy(() -> service.pay(amount, customerId,0))
                .isInstanceOf(CustomerNotFoundException.class)
                .hasMessageContaining("Not found customer", customerId.toString());

        when(repository.findById(customerId)).thenReturn(customer);
        assertThatNoException().isThrownBy(() -> service.pay(amount,customerId,0));


    }

    @Test
    void pay_invalidAmount_thenThrowInvalidAmountException() {
        // TODO: Keep going~
        long amount = -10_000L;
        Long customerId = 3423432L;
        Customer customer =new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);
        assertThatThrownBy(() -> service.pay(amount, customerId,0))
                .isInstanceOf(InvalidAmountException.class)
                .hasMessageContaining("InvalidAmount", amount);

    }

    @Test
    void payPass(){
        // TODO: Keep going~
        long amount = 10_000L;
        Long customerId = 3423432L;
        Customer customer =new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);
        Receipt result = service.pay(amount, customerId,0);
        assertThat(result).isNotNull();
        assertThat(result.getAmount()).isEqualTo(amount);

    }

    @Test
    void amount_standard_saveUpPoint(){
        long amount = 10_000L;
        Long customerId = 3423432L;
        Customer customer =new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);

        service.pay(amount, customerId,0);
        assertThat(customer.getPoint()).isNotNull();
    }

    @Test
    void amount_standard_customerSaveUpPoint(){
        long amount = 10_000L;
        Long customerId = 3423432L;
        Customer customer =new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);

        service.pay(amount, customerId,0);
        assertThat(customer.getPoint()).isNotNull();
        //적립률 2% 기준 테스트 1
        assertThat(customer.getPoint()).isEqualTo(200L);

        service.pay(amount, customerId,0);
        assertThat(customer.getPoint()).isNotNull();
        // 적립률 2% 기준 테스트 2 - sum checks
        assertThat(customer.getPoint()).isEqualTo(400L);
    }

    @Test
    void sms_notification_service_fail() {
        long amount = 10_000L;
        Long customerId = 3423432L;
        Customer customer =new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);

        Receipt result = service.pay(amount, customerId,0);

        SmsService mockSmsService = mock(SmsService.class);

        when(mockSmsService.doAlert(result)).thenReturn(false);
        assertThat(result).isNotNull();
        assertThat(result.getAmount()).isEqualTo(amount);
    }

    @Test
    void sms_notification_service_complete(){
        long amount = 10_000L;
        Long customerId = 3423432L;
        Customer customer =new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);

        Receipt result = service.pay(amount, customerId,0);

        SmsService mockSmsService = mock(SmsService.class);

        when(mockSmsService.doAlert(result)).thenReturn(true);
        assertThat(result).isNotNull();
        assertThat(result.getAmount()).isNotNull().isPositive();
    }


    @Test
    void pay_can_use_point(){
        long amount = 10_000L;
        Long customerId = 3423432L;
        Customer customer = new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);
        customer.savePoint(2000);

        Receipt result = service.pay(amount, customerId, 1000);
        assertThat(customer.getPoint()).isEqualTo(1180);
        assertThat(result.getAmount()).isEqualTo(9000);
    }

    @Test
    void pay_can_not_use_point(){
        long amount = 10_000L;
        Long customerId = 3423432L;
        Customer customer = new Customer(customerId);
        when(repository.findById(customerId)).thenReturn(customer);
        customer.savePoint(1000);

        Receipt result = service.pay(amount,customerId,1001);
        assertThat(customer.getPoint()).isEqualTo(1200);
        assertThat(result.getAmount()).isEqualTo(10000);

    }
}
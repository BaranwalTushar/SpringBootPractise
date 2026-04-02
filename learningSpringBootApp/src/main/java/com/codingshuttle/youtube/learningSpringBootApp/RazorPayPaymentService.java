package com.codingshuttle.youtube.learningSpringBootApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
//@Service
@ConditionalOnProperty(name = "payment.provider" , havingValue = "razorpay")
public class RazorPayPaymentService implements PaymentService {

    @Override
    public  String pay(){
        String payment = "Razorpay payment";
        System.out.println("Payment from "+ payment);
        return  payment;
    }
}


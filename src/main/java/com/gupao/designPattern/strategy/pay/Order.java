package com.gupao.designPattern.strategy.pay;

import com.gupao.designPattern.strategy.pay.payport.PayStrategy;
import com.gupao.designPattern.strategy.pay.payport.Payment;

public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public MsgResult pay(String payKey){
        Payment payment = PayStrategy.get(payKey);
        System.out.println(payment.getName());
        System.out.println(amount + "--交易金额");
        return payment.pay(uid,amount);
    }
}

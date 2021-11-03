package com.gupao.designPattern.strategy.pay;

import com.gupao.designPattern.strategy.pay.payport.PayStrategy;

public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "202103199999000000001", 324.45);
        MsgResult msgResult = order.pay(PayStrategy.ALI_PAY);
        System.out.println(msgResult);
    }
}

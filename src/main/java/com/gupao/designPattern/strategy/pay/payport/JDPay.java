package com.gupao.designPattern.strategy.pay.payport;

public class JDPay extends Payment{
    @Override
    public String getName() {
        return "JD白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}

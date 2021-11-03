package com.gupao.designPattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {

    public static final String ALI_PAY = "Alipay";
    public static final String JD_PAY = "JDpay";
    public static final String WECHART_PAY = "Wechartpay";
    public static final String UNION_PAY = "Unionpay";
    public static final String DEFAULT_PAY = ALI_PAY;


    private static Map<String, Payment> payStrategy = new HashMap<>();

    static {
        payStrategy.put(ALI_PAY, new AliPay());
        payStrategy.put(JD_PAY, new JDPay());
        payStrategy.put(WECHART_PAY, new WechatPay());
        payStrategy.put(UNION_PAY, new UnionPay());
//        payStrategy.put(DEFAULT_PAY, new AliPay());
    }

    public static Payment get(String payKey){
        if (!payStrategy.containsKey(payKey)){
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }
}

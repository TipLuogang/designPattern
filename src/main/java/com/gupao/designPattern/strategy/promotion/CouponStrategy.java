package com.gupao.designPattern.strategy.promotion;

public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券...价格减去优惠券面值");
    }
}

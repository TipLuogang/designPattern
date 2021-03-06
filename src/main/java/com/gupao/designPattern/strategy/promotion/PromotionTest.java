package com.gupao.designPattern.strategy.promotion;

import org.apache.commons.lang3.StringUtils;

public class PromotionTest {

//    public static void main(String[] args) {
//        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
//        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());
//
//        activity618.execute();
//        activity1111.execute();

//    }

//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//        String promotionKey = "COUPON";
//        if (StringUtils.equals(promotionKey,"COUPON")){
//            promotionActivity = new PromotionActivity(new CouponStrategy());
//        }else if(StringUtils.equals(promotionKey,"CASHBACK")){
//            promotionActivity = new PromotionActivity(new CashbackStrategy());
//        }
//        promotionActivity.execute();
//    }

    public static void main(String[] args) {
        PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";

        promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }

}

package com.tongdou.aop.spring.advisor.controlflow;

import com.tongdou.aop.spring.advisor.Buyer;

/**
 * Buyer delegate
 * Created by shenyuzhu on 2017/8/28.
 */
public class BuyerDelegate {
    private Buyer buyer;

    public void service() {
        buyer.greetTo();
        buyer.seviceTo();
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }


}

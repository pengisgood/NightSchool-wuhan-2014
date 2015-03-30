package org.nightschool.service;

import org.nightschool.model.Item;
import org.nightschool.service.iface.ChainDiscounter;

/**
 * Created by luchen on 3/29/15.
 */
public class MinusPriceDiscounter implements ChainDiscounter {
    private final int priority = 5;

    private ChainDiscounter successor;

    public Item discount(Item item) {
        System.out.println("=============== price before discount : " + item.getTotalPrice());
        if(item.getCategory().equalsIgnoreCase("USB")){
            item.setTotalPrice((item.getPrice()-10)*item.getNumber());
            System.out.println("=============== price after discount : " + item.getTotalPrice());
        }
        if(null != successor) {
            successor.discount(item);
        }
        return item;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public ChainDiscounter setSuccessor(ChainDiscounter discounter) {
            ChainDiscounter head = this;
            if(discounter.getPriority() > this.priority) {
                discounter.setSuccessor(this);
                head = discounter;
            } else if (successor != null) {
                successor = successor.setSuccessor(discounter);
            } else {
                successor = discounter;
            }
            return head;
    }

}

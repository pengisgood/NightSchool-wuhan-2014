package org.nightschool.service;

import org.nightschool.service.iface.ChainDiscounter;

/**
 * Created by luchen on 3/29/15.
 */
public class DiscounterManager {

    private static ChainDiscounter discounterChain;

    public static ChainDiscounter getChainDiscounter() {
        if(discounterChain == null) {
            initializeChain();
        }
        return discounterChain;
    }

    private static void initializeChain() {
        append(new MinusPriceDiscounter());
    }

    private static void append(ChainDiscounter discounter) {
        if(discounter != null) {
            discounterChain = discounter;
        } else {
            discounterChain = discounterChain.setSuccessor(discounter);
        }
    }

}

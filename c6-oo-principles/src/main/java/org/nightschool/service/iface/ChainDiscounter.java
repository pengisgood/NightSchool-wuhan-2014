package org.nightschool.service.iface;

import org.nightschool.model.Item;

/**
 * Created by luchen on 3/29/15.
 */
public interface ChainDiscounter {
    Item discount(Item item);
    int getPriority();
    ChainDiscounter setSuccessor(ChainDiscounter discounter);
}

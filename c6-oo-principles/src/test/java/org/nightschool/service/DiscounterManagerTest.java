package org.nightschool.service;

import org.junit.Test;
import org.nightschool.model.Item;
import org.nightschool.service.iface.ChainDiscounter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by luchen on 3/29/15.
 */
public class DiscounterManagerTest {
    private ChainDiscounter discounter = DiscounterManager.getChainDiscounter();

    @Test
    public void minus_price_discounter_should_caculate_cost_right() {
        Item item = new Item("Kingston", "USB", "imgurl", "desc", 1000, 100.00);
        item.setNumber(5);
        assertThat(discounter.discount(item).getTotalPrice()).isEqualTo(450.00);
    }

}

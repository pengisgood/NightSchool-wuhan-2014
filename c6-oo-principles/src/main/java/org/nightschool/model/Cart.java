package org.nightschool.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int totalItems = 10;
    private float totalPrice = 50.00f;

    private Item[] items = createFakeItems();

    private Item[] createFakeItems() {
        Item[] result = new Item[1];
        Item item = new Item("little fresh disk","DISK","little fresh","", 1000, 5.00);
        item.setNumber(10);
        result[0] = item;
        return result;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}

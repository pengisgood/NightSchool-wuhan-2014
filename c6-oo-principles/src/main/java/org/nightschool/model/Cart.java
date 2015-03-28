package org.nightschool.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int totalItems = 10;

    private List<Item> items = createFakeDisks();

    private List<Item> createFakeDisks() {
        List<Item> result = new ArrayList<Item>();
        Item item = new Item("小清新光盘","DISK","小清新，","", 1000, 5.00);
        item.setNumber(10);
        result.add(item);
        return result;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    private int totalPrice;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    private List<CartItem> cartItems = new ArrayList<CartItem>();



}

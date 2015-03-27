package org.nightschool.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int totalItems;

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

    public static class CartItem {
        String username;
        int itemid;
        int number;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getItemid() {
            return itemid;
        }

        public void setItemid(int itemid) {
            this.itemid = itemid;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

}

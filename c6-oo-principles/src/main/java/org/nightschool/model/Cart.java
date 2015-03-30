package org.nightschool.model;

import org.nightschool.dao.CartItemDao;
import org.nightschool.dao.ItemDao;
import org.nightschool.service.DiscounterManager;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int totalItems = 0;
    private float totalPrice = 0.00f;
    private List<Item> items = new ArrayList<Item>();
    private CartItemDao cartItemDao = new CartItemDao();
    private ItemDao itemDao = new ItemDao();

    public Cart() {
        initCart();
        System.out.println("========== items:" + items);
    }

    private void initCart() {
        List<CartItem> cartItems = cartItemDao.all();
        for(CartItem cartItem : cartItems) {
            Item item = itemDao.getById(cartItem.getItemid());
            caculateNumAndPrice(cartItem, item);
            items.add(item);
        }
    }

    private void caculateNumAndPrice(CartItem cartItem, Item item) {
        totalItems += cartItem.getNumber();
        caculateCost(cartItem, item);
        totalPrice += item.getTotalPrice();
    }

    private void caculateCost(CartItem cartItem, Item item) {
        item.setNumber(cartItem.getNumber());
        item.setTotalPrice(item.getPrice() * cartItem.getNumber());
        DiscounterManager.getChainDiscounter().discount(item);
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

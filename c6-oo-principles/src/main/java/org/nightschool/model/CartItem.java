package org.nightschool.model;

/**
 * Created by luchen on 3/28/15.
 */
public class CartItem {
    String username = "blacksea.chen@hotmail.com";
    int itemid;
    int number;

    public CartItem() {}

    public CartItem(int itemid, int number) {
        this.itemid = itemid;
        this.number = number;
    }

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

    @Override
    public int hashCode() {
        return username.hashCode() + itemid + number;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if(o != null && o instanceof CartItem) {

            result = this.itemid == ((CartItem) o).getItemid() && this.number == ((CartItem) o).getNumber();
        }
        return result;
    }
}

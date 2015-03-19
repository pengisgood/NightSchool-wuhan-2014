package org.nightschool.dao;

import org.nightschool.model.Disk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 12/26/14.
 */
public class CartDao {
    private final ArrayList<Disk> cart = new ArrayList<>();

    public void add(Disk disk) {
        int i = 0;
        for(i = 0; i < cart.size(); i++)
        {
            if(cart.get(i).getName().equals(disk.getName())) {
                break;
            }
        }

        if(i == cart.size()) {
            cart.add(disk);
        }
        else {
            cart.get(i).setNumber(cart.get(i).getNumber() + disk.getNumber());
        }
    }

    public List<Disk> cartList() {
        return cart;
    }
}

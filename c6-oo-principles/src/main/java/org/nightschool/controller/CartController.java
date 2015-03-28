package org.nightschool.controller;

import org.nightschool.dao.CartItemDao;
import org.nightschool.model.Cart;
import org.nightschool.model.CartItem;
import org.nightschool.model.Item;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by Thoughtworks on 12/26/14.
 */
@Path("/cart")
public class CartController {
    private CartItemDao cartItemDao = new CartItemDao();


    @GET
    public Cart getCart(){
        return new Cart();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Cart add(Item item) {
        CartItem cartItem = new CartItem();
        cartItem.setItemid(item.getId());
        cartItem.setNumber(item.getNumber());
        cartItemDao.add(cartItem);
        return new Cart();
    }
}

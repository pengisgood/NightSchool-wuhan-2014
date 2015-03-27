package org.nightschool.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.nightschool.model.Cart.*;

/**
 * Created by Thoughtworks on 12/26/14.
 */
@Path("/cart")
public class CartController {

    @GET
    public List<CartItem> list(){
        return null;
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(CartItem cartItem) {
    }
}

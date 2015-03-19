package org.nightschool.controller;

import org.nightschool.dao.CartDao;
import org.nightschool.model.Disk;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Thoughtworks on 12/26/14.
 */
@Path("/cart")
public class CartController {
    CartDao cartDao = new CartDao();

    @GET
    public List<Disk> list(){
        return cartDao.cartList();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Disk disk) {
        cartDao.add(disk);
    }
}

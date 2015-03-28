package org.nightschool.controller;

import org.nightschool.dao.ItemDao;
import org.nightschool.model.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Thoughtworks on 12/20/14.
 */
@Path("/disks")
@Produces(MediaType.APPLICATION_JSON)
public class ItemController {
    private final ItemDao itemDao = new ItemDao();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Item> list() {
        return itemDao.listDisks();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Item item) {
        itemDao.add(item);
    }

    @DELETE
    @Path("remove/{id}")
    public void remove(@PathParam("id") int index) {
        itemDao.remove(index);
    }
}

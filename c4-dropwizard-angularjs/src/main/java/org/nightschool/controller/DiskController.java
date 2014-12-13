package org.nightschool.controller;

import org.nightschool.model.Disk;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by twer on 12/14/14.
 */
@Path("/disks")
@Produces(MediaType.APPLICATION_JSON)
public class DiskController {

    @GET
    public List<Disk> list() {
        return new ArrayList<>();
    }
}

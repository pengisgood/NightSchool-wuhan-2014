package org.nightschool.controller;

import org.nightschool.model.Disk;
import org.nightschool.service.DiskServcie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by twer on 12/14/14.
 */
@Path("/disks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DiskController {

    private final DiskServcie diskServcie = new DiskServcie();

    @GET
    @Path("list")
    public List<Disk> list() {
        return diskServcie.listDisks();
    }

    @POST
    @Path("add")
    public Disk add(Disk disk) {
        diskServcie.add(disk);
        return disk;
    }
}

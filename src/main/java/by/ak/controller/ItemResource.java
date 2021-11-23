package by.ak.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

    @GET
    public String getItem() {
        return "item";
    }

    @POST
    public String createItem() {
        return "item";
    }

    @PUT
    public String updateItem() {
        return "item";
    }

    @DELETE
    public String deleteItem() {
        return "item";
    }
}

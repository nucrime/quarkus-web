package by.ak.controller;

import by.ak.model.Item;
import by.ak.service.ItemService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ItemResource {

    @Inject
    ItemService service;

    @GET
    @Path("/{id}")
    public Item getItem(@PathParam("id") Long id) {
        return service.getItem(id);
    }

    @POST
    public Response.Status createItem(Item item) {
        service.createItem(item);
        return Response.Status.OK;
    }

    @PUT
    public Response.Status updateItem(Item item) {
        service.updateItem(item);
        return Response.Status.NO_CONTENT;
    }

    @DELETE
    public Response.Status deleteItem(Item item) {
        service.deleteItem(item);
        return Response.Status.NO_CONTENT;
    }
}

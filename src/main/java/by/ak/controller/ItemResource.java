package by.ak.controller;

import by.ak.model.Item;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
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
import java.net.URI;

/**
 * <b>ItemResource controller</b>
 *
 * <pre>
 * Path: /item
 * Produces: application/json
 * Consumes: application/json
 * Methods:
 * - GET /item/{id}
 * - POST /item
 * - PUT /item/{id}
 * - DELETE /item/{id}
 * </pre>
 *
 * Returns Uni&#60;Item&#62;.
 *   Uni represents a lazy asynchronous action
 * @see Uni
 *
 * @see ApplicationScoped
 * @see MediaType
 * @see Item
 *
 * @author Aliaksandr Karankevich
 */
@Path(ItemResource.ITEM_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ItemResource {

    public static final String ITEM_PATH = "/item/";

    @GET
    @Path("/{id}")
    public Uni<Item> getItem(@PathParam("id") Long id) {
        return Item.findById(id);
    }

    @POST
    public Uni<Response> createItem(Item item) {
        return Panache.<Item>withTransaction(item::persist)
                .onItem().transform(inserted -> Response.created(URI.create(ITEM_PATH + inserted.id)).build());
    }

    @PUT
    public Uni<Response> updateItem(Item item) {
        return Item.update("where id = ?id", item).onItem().transform(updated -> Response.noContent().build());
    }

    @DELETE
    public Uni<Response> deleteItem(Item item) {
        return Item.deleteById(item.id).onItem().transform(updated -> Response.noContent().build());
    }
}

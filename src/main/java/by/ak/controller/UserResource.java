package by.ak.controller;

import by.ak.model.Item;
import by.ak.model.User;
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
 * <b>UserResource controller</b>
 *
 * <pre>
 * Path: /user
 * Produces: application/json
 * Consumes: application/json
 * Methods:
 * - GET /user/{id}
 * - POST /user
 * - PUT /user/{id}
 * - DELETE /user/{id}
 * </pre>
 *
 * Returns Uni&#60;User&#62;.
 *   Uni represents a lazy asynchronous action
 * @see Uni
 *
 * @see ApplicationScoped
 * @see MediaType
 * @see User
 *
 * @author Aliaksandr Karankevich
 */
@Path(UserResource.USER_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UserResource {

    public static final String USER_PATH = "/user";

    @GET
    @Path("/{id}")
    public Uni<User> getUser(@PathParam("id") Long id) {
        return User.findById(id);
    }

    @POST
    public Uni<Response> createUser(User item) {
        return Panache.<User>withTransaction(item::persist)
                .onItem().transform(inserted -> Response.created(URI.create(USER_PATH + inserted.id)).build());
    }

    @PUT
    public Uni<Response> updateUser(User item) {
        return User.update("where id = ?id", item).onItem().transform(updated -> Response.noContent().build());
    }

    @DELETE
    public Uni<Response> deleteUser(User item) {
        return User.deleteById(item.id).onItem().transform(updated -> Response.noContent().build());
    }
}

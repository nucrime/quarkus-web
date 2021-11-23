package by.ak.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @GET
    public String getUser() {
        return "User";
    }

    @POST
    public String createUser() {
        return "User";
    }

    @PUT
    public String updateUser() {
        return "User";
    }

    @DELETE
    public String deleteUser() {
        return "User";
    }
}

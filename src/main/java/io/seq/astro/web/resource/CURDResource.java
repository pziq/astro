package io.seq.astro.web.resource;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CURDResource<T> {

    @GET
    public Response read (
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user,
            @QueryParam("page")@DefaultValue("0") int pageIndex,
            @QueryParam("size") @DefaultValue("20") int pageSize);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create (
            @NotNull T request,
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user);

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete (
            @PathParam("id") Long id,
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user);

    @PUT
    @Transactional
    public Response update (
            T request,
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user);

}

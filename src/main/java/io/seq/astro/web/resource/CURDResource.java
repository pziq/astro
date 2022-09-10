package io.seq.astro.web.resource;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface CURDResource {

    @GET
    public Response read (
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user,
            @QueryParam("page") @DefaultValue("0") int pageIndex,
            @QueryParam("size") @DefaultValue("20") int pageSize);

    @POST
    @Transactional
    public Response create (
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user);

    @DELETE
    @Transactional
    public Response delete (
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user);

    @PUT
    @Transactional
    public Response update (
            @HeaderParam("transactionId") String transactionId,
            @NotNull @HeaderParam("channel") String channel,
            @NotNull @HeaderParam("user") String user);

}

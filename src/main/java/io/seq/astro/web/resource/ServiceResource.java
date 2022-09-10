package io.seq.astro.web.resource;

import io.quarkus.panache.common.Page;
import io.seq.astro.service.impl.ServiceImpl;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/service")
@Tag(name = "Service mangement", description = "various service related operations")
public class ServiceResource implements CURDResource{

    private final ServiceImpl serviceImpl;

    public ServiceResource(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Override
    public Response read(String transactionId, String channel, String user, int pageIndex, int pageSize) {
       //  return Response.ok(serviceImpl.read(pageIndex,pageSize)).build();
        return Response.status(Response.Status.OK)
                .entity(serviceImpl.read(pageIndex,pageSize))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .header("pageCount",10)
                .header("totalRecords",100)
                .build();
    }

    @Override
    public Response create(String transactionId, String channel, String user) {
        return null;
    }

    @Override
    public Response delete(String transactionId, String channel, String user) {
        return null;
    }

    @Override
    public Response update(String transactionId, String channel, String user) {
        return null;
    }

 /*   @GET
    @Path("/{serviceId}")
    public Response fetchByServiceId(@PathParam("serviceId") Long serviceId) {
        return serviceImpl.findById(serviceId)
                .map(customer -> Response.ok(customer).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }*/


//    @POST
//    public Response createService(@NotNull @Valid Service service, @Context UriInfo uriInfo) {
//        serviceImpl.save(service);
//        URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(service.getId())).build();
//        return Response.created(uri).entity(service).build();
//    }
//
//    @PUT
//    @Path("/{customerId}")
//    @APIResponse(
//            responseCode = "204",
//            description = "Customer updated",
//            content = @Content(
//                    mediaType = MediaType.APPLICATION_JSON,
//                    schema = @Schema(type = SchemaType.OBJECT, implementation = Service.class)
//            )
//    )
//    @APIResponse(
//            responseCode = "400",
//            description = "Invalid Customer",
//            content = @Content(mediaType = MediaType.APPLICATION_JSON)
//    )
//    @APIResponse(
//            responseCode = "400",
//            description = "Customer object does not have customerId",
//            content = @Content(mediaType = MediaType.APPLICATION_JSON)
//    )
//    @APIResponse(
//            responseCode = "400",
//            description = "Path variable customerId does not match Customer.customerId",
//            content = @Content(mediaType = MediaType.APPLICATION_JSON)
//    )
//    @APIResponse(
//            responseCode = "404",
//            description = "No Customer found for customerId provided",
//            content = @Content(mediaType = MediaType.APPLICATION_JSON)
//    )
//    public Response put(@Parameter(name = "customerId", required = true) @PathParam("id") Long id, @NotNull @Valid Service service) {
//        if (!Objects.equals(id, service.getId())) {
//            throw new ServiceException("Path variable customerId does not match Customer.customerId");
//        }
//        serviceImpl.update(service);
//        return Response.status(Response.Status.NO_CONTENT).build();
//    }

}

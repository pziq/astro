package io.seq.astro.web.resource;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.seq.astro.persistence.entity.ServiceEntity;
import io.seq.astro.domain.Service;
import io.seq.astro.service.impl.ServiceImpl;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/service")
@Tag(name = "Service management", description = "various service related operations")
public class ServiceResource implements CURDResource<Service> {

    private final ServiceImpl serviceImpl;

    public ServiceResource(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @Operation(summary = "fetch services", description = "Fetch service with pagination.")
    public Response read(String transactionId, String channel, String user, int pageIndex, int pageSize) {
        PanacheQuery<ServiceEntity> serviceEntities = ServiceEntity.findAll();
        return Response.status(Response.Status.OK).entity(serviceEntities.page(Page.of(pageIndex, pageSize)).list()).type(MediaType.APPLICATION_JSON_TYPE).header("pageCount", serviceEntities.pageCount()).header("totalRecords", serviceEntities.count()).build();
    }

    @POST
    @Operation(summary = "save new service", description = "Creates new service with given details.")
    @RequestBody(required = true, content = @Content(schema = @Schema(implementation = Service.class, required = true, requiredProperties = {"serviceId", "name"})))
    public Response create(Service model, String transactionId, String channel, String user) {
        serviceImpl.save(model);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Response delete(Long id, String transactionId, String channel, String user) {
        ServiceEntity.deleteById(id);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Response update(String transactionId, String channel, String user) {
        return null;
    }


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

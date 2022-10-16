package io.seq.astro.web.resource;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.seq.astro.persistence.entity.ServiceEntity;
import io.seq.astro.domain.Service;
import io.seq.astro.service.impl.ServiceImpl;
import io.seq.astro.utils.exception.ErrorMessage;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
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
        return Response
                .status(Response.Status.OK)
                .entity(serviceEntities
                        .page(Page.of(pageIndex, pageSize))
                        .list())
                .type(MediaType.APPLICATION_JSON_TYPE)
                .header("pageCount", serviceEntities.pageCount())
                .header("totalRecords", serviceEntities.count())
                .build();
    }

    @POST
    @Operation(summary = "save new service", description = "Creates new service with given details.")
    @RequestBody(required = true, content = @Content(schema = @Schema(implementation = Service.class, required = true)))
    @APIResponses(value = { @APIResponse(responseCode = "201", description = "Success",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Service.class))),
            @APIResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))})

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
    public Response update(Service request, String transactionId, String channel, String user) {
        return null;
    }

}

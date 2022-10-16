package io.seq.astro.domain;

import io.seq.astro.utils.enums.Status;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Schema(name = "Service", description = "service details")
public class Service {

    @NotBlank(message = "serviceId should not be blank")
    @Schema(title = "service Id",description = "Unique id to identify the service")
    private String serviceId;
    @Schema(title = "service name",description = "The name of the service")
    @NotBlank(message = "Service name should not be blank")
    private String name;
    @NotBlank
    @Schema(title = "status",description = "The status of the service")
    private Status status;
    @Email(message = "email id must be well-formed")
    private String email;
    private String website;

    /* getters and setters */
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

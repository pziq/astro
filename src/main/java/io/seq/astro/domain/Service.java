package io.seq.astro.domain;

import io.seq.astro.utils.enums.Status;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Service", description = "service details")
public class Service {

    private String serviceId;
    private String name;
    private Status status;
    private String email;

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

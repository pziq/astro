package io.seq.astro.persistence.entity;

import io.seq.astro.global.enumerations.Status;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "services",
        indexes = {
                @Index(name = "idx_service_id",columnList = "serviceId"),
                @Index(name = "idx_status" , columnList = "status")
        }
)
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotEmpty
    private String serviceId;
    private String name;
    private Status status;
    @Email
    private String email;

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

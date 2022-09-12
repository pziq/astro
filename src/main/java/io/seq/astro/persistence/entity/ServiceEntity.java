package io.seq.astro.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.seq.astro.utils.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "services",
        indexes = {
                @Index(name = "idx_service_id",columnList = "serviceId"),
                @Index(name = "idx_status" , columnList = "status")
        }
)
public class ServiceEntity extends PanacheEntity {

    private String serviceId;
    private String name;
    private Status status;
    @Email
    private String email;

    public ServiceEntity findByName(String name){
        return find("name", name).firstResult();
    }

    public List<ServiceEntity> findAlive(){
        return list("status", Status.Active);
    }

    public void deleteInactive(){
        delete("name", "Stef");
    }


    // getters and setters
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

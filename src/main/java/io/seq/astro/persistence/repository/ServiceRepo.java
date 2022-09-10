package io.seq.astro.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.seq.astro.global.enumerations.Status;
import io.seq.astro.persistence.entity.ServiceEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ServiceRepo implements PanacheRepository<ServiceEntity> {

    public ServiceEntity findByName(String name){
        return find("name", name).firstResult();
    }

    public List<ServiceEntity> findAlive(){
        return list("status", Status.Active);
    }

    public void deleteInactive(){
        delete("name", "Stef");
    }
}

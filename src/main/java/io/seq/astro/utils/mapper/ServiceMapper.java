package io.seq.astro.utils.mapper;

import io.seq.astro.persistence.entity.ServiceEntity;
import io.seq.astro.domain.Service;

public class ServiceMapper implements BeanMapper<Service,ServiceEntity>{

    @Override
    public ServiceEntity domainToEntity(Service domain, ServiceEntity entity) {

        entity.setServiceId(domain.getServiceId());
        entity.setName(domain.getName());
        entity.setStatus(domain.getStatus());
        entity.setEmail(domain.getEmail());

        return entity;
    }

    @Override
    public Service entityToDomain(Service domain, ServiceEntity entity) {

        domain.setServiceId(entity.getServiceId());
        domain.setName(entity.getName());
        domain.setStatus(entity.getStatus());
        domain.setEmail(entity.getEmail());

        return domain;
    }
}

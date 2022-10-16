package io.seq.astro.service.impl;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Page;
import io.seq.astro.persistence.entity.ServiceEntity;
import io.seq.astro.domain.Service;
import io.seq.astro.utils.mapper.ServiceMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@Transactional
public class ServiceImpl {

    public List<ServiceEntity> read(int pageIndex, int pageSize) {
        return ServiceEntity.findAll().page(Page.of(pageIndex, pageSize)).list();
    }


/*    public Optional<Service> findById(@NonNull Long serviceId) {
        return serviceRepo.findByIdOptional(serviceId)
                .map(serviceMapper::toDomain);
    }*/


    public void save(@Valid Service service) {
        Log.debug("Saving service: " + service.toString());
        ServiceEntity entity = new ServiceMapper().domainToEntity(service, new ServiceEntity());
        ServiceEntity.persist(entity);
        Log.info("service persisted");
    }

 /*   @Transactional
    public void update(@Valid Service service) {
        Log.debug("Updating Customer: " + service.toString());
        if (Objects.isNull(service.getServiceId())) {
            throw new ServiceException("Service does not have an id");
        }
        ServiceEntity entity = serviceRepo.findByIdOptional(service.getId())
                .orElseThrow(() -> new ServiceException("No Customer found for customerId[%s]", service.getId()));
        serviceMapper.updateEntityFromDomain(service, entity);
        serviceRepo.persist(entity);
        serviceMapper.updateDomainFromEntity(entity, service);
    }*/


}

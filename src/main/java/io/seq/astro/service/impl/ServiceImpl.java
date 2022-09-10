package io.seq.astro.service.impl;

import io.quarkus.panache.common.Page;
import io.seq.astro.persistence.entity.ServiceEntity;
import io.seq.astro.persistence.repository.ServiceRepo;
import io.seq.astro.service.domain.Service;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ServiceImpl {

    private final ServiceRepo serviceRepo;

    public ServiceImpl(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    public List<ServiceEntity> read(int pageIndex,int pageSize) {
        return serviceRepo.findAll().page(Page.of(pageIndex,pageSize)).list();
    }


/*    public Optional<Service> findById(@NonNull Long serviceId) {
        return serviceRepo.findByIdOptional(serviceId)
                .map(serviceMapper::toDomain);
    }*/

/*    @Transactional
    public void save(@Valid Service service) {
        Log.debug("Saving service: " + service.toString());
        ServiceEntity entity = serviceMapper.toEntity(service);
        serviceRepo.persist(entity);
        serviceMapper.updateDomainFromEntity(entity, service);
    }*/

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

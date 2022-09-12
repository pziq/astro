package io.seq.astro.utils.mapper;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface BeanMapper<D,E> {

    public E domainToEntity(D domain,E entity);
    public D entityToDomain(D domain,E entity);

}

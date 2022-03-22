package com.coderhouse.session.eight.plainv2.entities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericService<T extends BusinessBehaviour<T, ID>, ID> {

    private final JpaRepository<T, ID> tidJpaRepository;

    protected GenericService(JpaRepository<T, ID> tidJpaRepository) {
        this.tidJpaRepository = tidJpaRepository;
    }

    public T getById(ID id) {
        return this.tidJpaRepository.getById(id);
    }

    public T create(T toCreate) {
        toCreate.doCreation();
        return this.tidJpaRepository.saveAndFlush(toCreate);
    }

    public T update(T toUpdate) {
        T oldEntity = this.tidJpaRepository.getById(toUpdate.getId());
        oldEntity.voidUpdate();
        return this.tidJpaRepository.saveAndFlush(oldEntity.copyFrom(toUpdate));
    }

    public Page<T> list() {
        return this.tidJpaRepository.findAll(Pageable.unpaged());
    }

    public void delete(ID id) {
        T oldEntity = this.tidJpaRepository.getById(id);
        oldEntity.updateFieldsForDelete();
        oldEntity.voidUpdate();
        this.tidJpaRepository.saveAndFlush(oldEntity);
    }
}

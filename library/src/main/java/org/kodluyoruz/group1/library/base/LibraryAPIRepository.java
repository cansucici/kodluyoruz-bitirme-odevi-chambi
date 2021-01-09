package org.kodluyoruz.group1.library.base;

import org.kodluyoruz.group1.library.model.entities.BaseEntity;

import java.util.Collection;

public interface LibraryAPIRepository<T extends BaseEntity, ID extends Long> {

    Collection<T> list();

    T create(T entity);

    T update(T entity);

    void delete(ID id);


}

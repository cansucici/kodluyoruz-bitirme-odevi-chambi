package org.kodluyoruz.group1.library.base;


import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.kodluyoruz.group1.library.model.entities.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public class LibraryAPIRepositoryImpl <T extends BaseEntity, ID extends Long> implements
LibraryAPIRepository<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entity;

    @SuppressWarnings("unchecked")
    public LibraryAPIRepositoryImpl() {
        this.entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession(){
        return entityManager.unwrap(Session.class);
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //*******************************************//
    @Override
    public Collection<T> list() {
            return getSession()
                    .createQuery("from " + entity.getName(), entity)
                    .getResultList();
    }

    @Override
    public T create(T entity) {
        getSession().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getSession().update(entity);
        return entity;
    }

    @Override
    public void delete(ID id) {
        getSession()
                .createQuery("update " + entity.getName() + " set status = 'DELETED' where id=:entityId ")
                .setParameter("entityId", id)
                .executeUpdate();

    }
}

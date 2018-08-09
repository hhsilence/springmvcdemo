package com.itec.clinic.dao;

import com.itec.clinic.entity.Page;
import com.itec.clinic.entity.Person;

import java.io.Serializable;
import java.util.List;

public interface DomainDao <T,PK extends Serializable>{
    Person login(T entity);

    T load(PK id);

    T get(PK id);

    List<T> findAll();

//    void persist(T entity);

    PK add(T entity);

//    void saveOrUpdate(T entity);

    void update(T entity);

    void delete(PK id);

//    void flush();

    List<T> searchByName(String name);

    List<T> findByPage(Page page);

    int getTotalCount();
}

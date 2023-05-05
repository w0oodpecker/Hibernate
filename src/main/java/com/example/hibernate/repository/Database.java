package com.example.hibernate.repository;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class Database {

    @PersistenceContext
    EntityManager entityManager;

    Database(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Persons> getPersonsByCity(String city) {
        String query="select age, name, surname, phone_number, city_of_living from persons where persons.city_of_living=:city";
        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery(query, Persons.class).setParameter("city", city);
        List<Persons> list = (List<Persons>) nativeQuery.getResultList();
        return list;
    }
}

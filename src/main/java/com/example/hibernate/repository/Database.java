package com.example.hibernate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Database extends CrudRepository<Persons, PesronsPK> {

    List<Persons> findAllByCityOfLiving(String cityOfLiving);
    List<Persons> findAllByAgeLessThanOrderByAgeAsc(int age);
    Optional<Persons> findAllByNameAndSurnameAndAge(String name, String surname, int age);

}

package com.example.hibernate.controller;

import com.example.hibernate.repository.Database;
import com.example.hibernate.repository.Persons;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class HibernateController {

    private Database database;

    HibernateController(Database database) {
        this.database = database;
    }

    @GetMapping("/persons/by-nameandsurnameandage")
    public ResponseEntity<Optional<Persons>> fetchPersonsByNameAndSurnameAndAge(@RequestParam("name") String name,
                                                                            @RequestParam("surname") String surname,
                                                                            @RequestParam("age") int age) {
        Optional<Persons> optional = database.findAllByNameAndSurnameAndAge(name, surname, age);
        return new ResponseEntity<>(optional, HttpStatus.OK);
    }


    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Persons>> fetchPersonsByCityOfLiving(@RequestParam("city") String cityOfLiving) {
        List<Persons> list = database.findAllByCityOfLiving(cityOfLiving);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/persons/by-age")
    public ResponseEntity<List<Persons>> fetchPersonsByAge(@RequestParam("age") int age) {
        List<Persons> list = database.findAllByAgeLessThanOrderByAgeAsc(age);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

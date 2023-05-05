package com.example.hibernate.controller;

import com.example.hibernate.repository.Database;
import com.example.hibernate.repository.Persons;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HibernateController {

    private Database database;

    HibernateController(Database database) {
        this.database = database;
    }

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Persons>> fetchPersonsByCity(@RequestParam("city") String city) {
        List<Persons> list = database.getPersonsByCity(city);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

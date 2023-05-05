package com.example.hibernate.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Entity
@IdClass(PesronsPK.class)
public class Persons {

    @Id
    @Column(nullable = false, length = 255)
    private String name;
    @Id
    @Column(nullable = false, length = 255)
    private String surname;
    @Id
    @Column(nullable = false, length = 3)
    private int age;
    @Column(nullable = true, length = 11)
    private String phone_number;
    @Column(nullable = true, length = 255)
    private String city_of_living;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setCity_of_living(String city_of_living) {
        this.city_of_living = city_of_living;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity_of_living() {
        return city_of_living;
    }

    public String getPhone_number() {
        return phone_number;
    }
}

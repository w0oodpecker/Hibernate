package com.example.hibernate.repository;


import java.io.Serializable;

public class PesronsPK implements Serializable {

    private String name;
    private String surname;
    private int age;


    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = result * 31 + surname.hashCode();
        result = result * 31 + age;
        return result;
    }

}

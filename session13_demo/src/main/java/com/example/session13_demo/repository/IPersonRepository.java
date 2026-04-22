package com.example.session13_demo.repository;

import com.example.session13_demo.model.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAll();

    void save(Person person);
}

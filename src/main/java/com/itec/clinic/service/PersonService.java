package com.itec.clinic.service;

import com.itec.clinic.entity.Page;
import com.itec.clinic.entity.Person;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PersonService {
    String addPerson(Person person);

    void editPerson(Person person);

    List<Person> findAll();

    Person findById(String id);

    void deletePerson(String id);

    List<Person> searchByPersonName(String name);

    List<Person> findPersonByPage(Page page);

    int getTotalCount();
}

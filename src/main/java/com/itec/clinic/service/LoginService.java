package com.itec.clinic.service;

import com.itec.clinic.dao.PersonDao;
import com.itec.clinic.dao.PersonDaoImpl;
import com.itec.clinic.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PersonDao personDao = new PersonDaoImpl();

    public Person login(Person person){
       return personDao.login(person);
    }
}

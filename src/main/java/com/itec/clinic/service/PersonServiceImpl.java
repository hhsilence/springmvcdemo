package com.itec.clinic.service;

import com.itec.clinic.dao.PersonDao;
import com.itec.clinic.entity.Page;
import com.itec.clinic.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDao personDao;

    @Override
    public String addPerson(Person person){
        return personDao.add(person);
    }

    @Override
    public List<Person> findAll() {
        List<Person> list = personDao.findAll();
        return list;
    }

    @Override
    public void editPerson(Person person) {
        personDao.update(person);
    }

    public Person findById(String id){
        return personDao.load(id);
    }

    @Override
    public void deletePerson(String id) {
        personDao.delete(id);
    }

    @Override
    public List<Person> searchByPersonName(String name) {
        List<Person> list= personDao.searchByName(name);
        return list;
    }

    @Override
    public List<Person> findPersonByPage(Page page) {
        List<Person> list = personDao.findByPage(page);
        return list;
    }

    @Override
    public int getTotalCount() {
        return personDao.getTotalCount();
    }
}

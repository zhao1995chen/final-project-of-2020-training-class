package com.game.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.game.spring.dao.PersonDAO;
import com.game.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }

    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }

    @Override
    @Transactional
    public List<String> PersonsCheck() {
        return this.personDAO.PersonsCheck();
    }

    @Override
    @Transactional
    public boolean PersonsLogin(String a, String p) {
        return this.personDAO.PersonsLogin(a,p);
    }
}

package com.game.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.game.spring.model.Person;
import java.util.Iterator;
import org.hibernate.Criteria;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details=" + p);
    }

    @Override
    public void updatePerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for (Person p : personsList) {
            logger.info("Person List::" + p);
        }
        return personsList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person loaded successfully, Person details=" + p);
        return p;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details=" + p);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<String> PersonsCheck() {
        Session session = this.sessionFactory.getCurrentSession();
        List<String> personsList = session.createQuery("select username from Person").list();

        return personsList;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean PersonsLogin(String a, String p) {
        Session session = this.sessionFactory.getCurrentSession();       
        Criteria criteria = session.createCriteria(Person.class);
            Iterator Person = criteria.list().iterator();
            while (Person.hasNext()) {
                Person person = (Person) Person.next();
                if (person.getUsername().equals(a) && person.getPassword().equals(p)) {
                    return true;
                }
            }
        return false;
    }

}

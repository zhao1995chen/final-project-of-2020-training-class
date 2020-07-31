package com.game.spring.dao;

import java.util.List;

import com.game.spring.model.Person;

public interface PersonDAO {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
        public List<String> PersonsCheck();
	public Person getPersonById(int id);
	public void removePerson(int id);
        public boolean PersonsLogin(String a, String p);
}

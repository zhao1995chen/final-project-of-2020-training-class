package com.game.spring.service;

import java.util.List;

import com.game.spring.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
        public List<String> PersonsCheck();
	public Person getPersonById(int id);
	public void removePerson(int id);
        public boolean PersonsLogin(String a, String p);
	
}

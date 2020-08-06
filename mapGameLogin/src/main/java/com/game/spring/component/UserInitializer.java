package com.game.spring.component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.spring.dao.PersonDao;
import com.game.spring.entity.Person;

@Component
public class UserInitializer {

	@Autowired
	private PersonDao personDao;

	private Logger log = LoggerFactory.getLogger(UserInitializer.class);

	public static List<Person> personList = new ArrayList<Person>();

	@PostConstruct
	public void init() {
		try {
			List<Person> personList = personDao.findAll();
			if (personList != null) {
				for (Person p : personList) {
					personList.add(p);
					log.info("person--->>" + p.getUsername());
				}
			}
		} catch (Exception e) {

		}
	}

}

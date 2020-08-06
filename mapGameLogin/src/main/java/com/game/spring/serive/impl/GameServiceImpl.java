package com.game.spring.serive.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.spring.component.UserInitializer;
import com.game.spring.dao.PersonDao;
import com.game.spring.entity.Person;
import com.game.spring.service.GameService;
import com.game.spring.vo.Permission;
import com.game.spring.vo.PersonResultVO;
import com.game.spring.vo.PersonVO;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private PersonDao personDao;

	@Transactional(readOnly = true)
	@Override
	public List<PersonVO> getAllPerson() {
		
		List<PersonVO> resultList = new ArrayList<PersonVO>();
		List<Person> personList = personDao.findAll();
		if (personList != null) {
			for (Person p : personList) {
				PersonVO v = new PersonVO();
				v.setName(p.getUsername());
				v.setPassword(p.getPassword());
				List<Permission> permissionList = new ArrayList<Permission>();
				permissionList.add(new Permission("1112323", Arrays.asList("444", "22222")));
				permissionList.add(new Permission("1112323", Arrays.asList("444", "22222")));
				v.setPermissionList(permissionList);
				resultList.add(v);
			}
		}
		return resultList;
	}

	@Transactional(readOnly = true)
	@Override
	public PersonResultVO checkLogin(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setName(person.getName());
		Person existedPerson = personDao.findByUsernameAndPassword(person.getName(), person.getPassword());
		if (existedPerson != null) {
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PersonResultVO checkName(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setName(person.getName());
		Person existedPerson = personDao.findByUsernameAndPassword(person.getName(), person.getPassword());
		if (existedPerson == null) {
			Person p = new Person();
			p.setUsername(person.getName());
			p.setPassword(person.getPassword());
			personDao.save(p);
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}
}

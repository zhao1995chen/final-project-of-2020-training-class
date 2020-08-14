package com.game.spring.service;

import java.util.List;

import com.game.spring.entity.*;
import com.game.spring.vo.*;

public interface GameService {

	public List<PersonVO> getAllPerson();

	public PersonResultVO checkLogin(PersonVO p);

	public PersonResultVO register(Person p);
	
	public PersonResultVO checkName(PersonVO p);
	
	public PersonResultVO checkNametest(PersonVO p);
	
	public PersonResultVO changePassword(PersonVO p);
	
	public boolean activeUser(String code);
	
	public boolean checkUser(String name);
}

package com.game.spring.service;

import java.util.List;

import com.game.spring.vo.PersonResultVO;
import com.game.spring.vo.PersonVO;

public interface GameService {

	public List<PersonVO> getAllPerson();

	public PersonResultVO checkLogin(PersonVO p);

	public PersonResultVO checkName(PersonVO p);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.game.spring.service.GameService;
import com.game.spring.vo.PersonResultVO;
import com.game.spring.vo.PersonVO;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private GameService gameService;

	/*
	 * example
	 */
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public List<PersonVO> getAllPerson() {
		return gameService.getAllPerson();
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/checkName", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PersonResultVO checkName(@RequestBody PersonVO p) {
		return gameService.checkName(p);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PersonResultVO checkLogin(@RequestBody PersonVO p) {
		return gameService.checkLogin(p);
	}

}

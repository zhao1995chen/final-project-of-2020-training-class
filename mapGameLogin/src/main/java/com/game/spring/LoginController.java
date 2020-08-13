/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.game.spring.entity.*;
import com.game.spring.vo.*;
import com.game.spring.service.GameService;

/**
 *
 * @author Administrator
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private GameService gameService;

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public List<PersonVO> getAllPerson() {
		return gameService.getAllPerson();
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PersonResultVO register(@RequestBody Person p) {
		return gameService.register(p);
	}	

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/checkName", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PersonResultVO checkName(@RequestBody PersonVO p) {
		return gameService.checkName(p);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PersonResultVO changePassword(@RequestBody PersonVO p) {
		return gameService.changePassword(p);
	}	

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PersonResultVO checkLogin(@RequestBody PersonVO p) {
		return gameService.checkLogin(p);
	}

}

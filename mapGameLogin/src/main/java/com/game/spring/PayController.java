package com.game.spring;


import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.game.spring.service.GameService;

import ecpay.payment.integration.domain.*;


/**
 *
 * @author Administrator
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Pay")
public class PayController {

	@Autowired
	private GameService gameService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/toPay", method = RequestMethod.POST, produces = "application/json")
	public String toPay(@RequestBody AioCheckOutALL a) throws UnsupportedEncodingException {
		return gameService.toPay(a);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/payQuery", method = RequestMethod.POST, produces = "application/json")
	public String payQuery(@RequestBody QueryTradeInfoObj q) throws UnsupportedEncodingException{
		return gameService.payQuery(q);
	}
}
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
import com.game.spring.vo.PersonResultVO;
import com.game.spring.vo.PersonVO;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.ecpayOperator.EcpayFunction;

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
			p.setEmail(person.getEmail());
			personDao.save(p);
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}
	//pay
	private static void initial(){
		all = new AllInOne("");
	}
		public static AllInOne all;
		@Transactional(propagation = Propagation.REQUIRED)
		@Override
		public String toPay(AioCheckOutALL a) {		
			initial();
			a.setMerchantID("2000132");
			a.setMerchantTradeNo(a.getMerchantTradeNo());
			a.setMerchantTradeDate(a.getMerchantTradeDate());
			a.setTotalAmount(a.getTotalAmount());
			a.setTradeDesc(a.getTradeDesc());
			a.setItemName("鑽石");
			a.setOrderResultURL("http://localhost/mapGame/welcome.jsp");
			a.setReturnURL("http://localhost/mapGame/welcome.jsp");
			a.setItemURL("http://localhost/mapGame/welcome.jsp");
			a.setClientBackURL("http://localhost/mapGame/welcome.jsp");
			a.setNeedExtraPaidInfo("N");
			String form = all.aioCheckOut(a, null);	
			return form;
		}
}

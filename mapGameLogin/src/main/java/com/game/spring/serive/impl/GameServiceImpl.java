package com.game.spring.serive.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.spring.dao.*;
import com.game.spring.entity.*;
import com.game.spring.mail.*;
import com.game.spring.vo.*;
import com.game.spring.service.GameService;



@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private PersonDao personDao;

	// 找所有帳號
	@Transactional(readOnly = true)
	@Override
	public List<PersonVO> getAllPerson() {

		List<PersonVO> resultList = new ArrayList<PersonVO>();
		List<Person> personList = personDao.findAll();
		if (personList != null) {
			for (Person p : personList) {
				PersonVO v = new PersonVO();
				v.setUsername(p.getUsername());
				v.setPassword(p.getPassword());
				resultList.add(v);
			}
		}
		return resultList;
	}

	// 登入
	@Transactional(readOnly = true)
	@Override
	public PersonResultVO checkLogin(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		Person existedPerson = personDao.findByUsernameAndPassword(person.getUsername(), person.getPassword());
		if (existedPerson != null && existedPerson.getState() == 1) {
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 註冊
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PersonResultVO register(Person person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		String code = CodeUtil.generateUniqueCode();
		Person existedPerson = personDao.findByUsernameAndPassword(person.getUsername(), person.getPassword());
		if (!person.getEmail().matches("^\\w+@(\\w+\\.)+\\w+$")) {
			result.setStatus(false);
			return result;
		}
		if (existedPerson == null) {
			Person p = new Person();
			p.setUsername(person.getUsername());
			p.setPassword(person.getPassword());
			p.setEmail(person.getEmail());
			p.setState(0);
			p.setCode(code);
			personDao.save(p);
			new Thread(new MailUtil(person.getEmail(), code)).start();
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 改密碼
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PersonResultVO changePassword(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		Person existedPerson = personDao.findByUsername(person.getUsername());
		if (existedPerson != null) {
			existedPerson.setPassword(person.getPassword());
			personDao.save(existedPerson);
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 檢查名子
	public Person checkUser1(String name) {
		try {
			Person p =null;
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps =conn.prepareStatement("select * from person where username=?");
            ps.setString(1, name); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	p = new Person();
            	p.setUsername(rs.getString("username"));          	
            }
            return p;                    	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	@Transactional(readOnly = true)
	@Override
	public boolean checkUser(String name) {
		if (checkUser1(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public PersonResultVO checkName(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		Person existedPerson = personDao.findByUsernameAndEmail(person.getUsername(), person.getEmail());
		if (existedPerson != null) {
			new Thread(new MailUtil(person.getEmail(), existedPerson.getUsername())).start();
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 信箱驗證
	public int activeUser1(String code) {
		int num = 0;
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "update person set state=1 where code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			num = pstmt.executeUpdate();
			DBUtil.close(conn, pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;

	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public boolean activeUser(String code) {
		System.out.println(code);
		// if(personDao.activeUser(1, code)>0){
		if (activeUser1(code) > 0) {
			return true;
		} else {
			return false;
		}
	}

}

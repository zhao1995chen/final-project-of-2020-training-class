package com.game.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

	//
	public Person findByUsernameAndPassword(String Username, String Password);

	//
	public List<Person> findByUsername(String Username);

	//
	@Query("from Person p where p.username=:username")
	public Person findByHQL(@Param("username") String name);

	//
	@Query(value = "update Person p set p.username=:username where p.pid=:id ", nativeQuery = true)
	public void updateOne(@Param("username") String userName, @Param("id") Integer id);
}

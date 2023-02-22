package com.starter.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.starter.demo.entites.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
	@Query(
			"SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId = ?1")
	Boolean isPersonExitsById(Integer id); 
	
//	@Query(
//			"SELECT personName FROM Person s WHERE s.personName = ?1")
	List<Person> findByPersonName(String personName);
	
	
	Person findByPersonId(Integer personId);
}

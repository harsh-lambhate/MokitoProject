package com.starter.demo.entites.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.demo.entites.Person;
import com.starter.demo.repo.PersonRepo;

@Service

//Class
public class PersonService {
	
 @Autowired
 private PersonRepo repo;

 public List<Person> getAllPerson(){
	 List<Person> findAll = this.repo.findAll();
	 System.out.println("{getAllPerson API call :: List of persons} : "+findAll);
     return findAll;
 }

	
	public Person createPerson(Person person) {
		Person save = repo.save(person);
		System.out.println("{createPerson API call :: sucessfully save} : ");
		return save;
	}

	
	public List<Person> getPersonName(String personName) {
		List<Person> findByPersonName = repo.findByPersonName(personName);
		 System.out.println("{getPersonName API call :: findByPersonName} : "+findByPersonName);
		return findByPersonName;
	}
	
	
	public Person getPersonById(int Id) {
		Person findByPersonId = repo.findByPersonId(Id);
		 System.out.println("{getPersonById API call :: findByPersonId} : "+findByPersonId);
		return findByPersonId;
	}
	
	
	 public String getPersonDelete(int id) {
		 repo.deleteById(id);
		 System.out.println("{getPersonDelete API call}");
	        return "product removed !! " + id;
	    }
	
	public PersonService(PersonRepo repo)
	 {
	     this.repo = repo;
	 }
}
package com.starter.demo.entites.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.starter.demo.entites.Person;
import com.starter.demo.entites.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
 
    @Autowired
    private PersonService service;
 
    @GetMapping
    public ResponseEntity<?> getAllPersons() {
        return ResponseEntity.ok(this.service.getAllPerson());
    }
	
	//create
	@PostMapping()
	public ResponseEntity<Person> createHotel(@RequestBody Person person){
		Person create = service.createPerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
	}
	
	//getSingle
	@GetMapping("/get/{personName}")
	public ResponseEntity<List<Person>> getPersonByName(@PathVariable String personName){
		List<Person> person = service.getPersonName(personName);
		return ResponseEntity.status(HttpStatus.OK).body(person);
	}
	
	//getSingle
		@GetMapping("/{personId}")
		public ResponseEntity<Person> getPersonById(@PathVariable int personId){
			Person personById = service.getPersonById(personId);
			return ResponseEntity.status(HttpStatus.OK).body(personById);
		}
	
	 
	//delete
	@DeleteMapping(value="/delete/{personId}")
	public ResponseEntity<String> removePerson(@PathVariable int personId) {
		String personDelete = service.getPersonDelete(personId);
		if(personId>0) {
		return ResponseEntity.status(HttpStatus.OK).body(personDelete);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID NOT FOUND");
		}
	}
}
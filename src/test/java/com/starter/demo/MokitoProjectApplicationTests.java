package com.starter.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.starter.demo.entites.Person;
import com.starter.demo.entites.services.PersonService;
import com.starter.demo.repo.PersonRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
class MokitoProjectApplicationTests {

	@Mock
	private PersonRepo personRepo;
	@InjectMocks
	private PersonService personService;
	
	@BeforeEach
	public void beforeMethod() {
		System.out.println("----------------------before method call !!----------------------");
	}
	
	@AfterEach
	public void afterMethod() {
		System.out.println("----------------------after method call !!----------------------");
	}
	
   //test to get All results of person
	@Test
	public void getMoviesTest() {
		Person person = new Person(1, "Bahubali", "Nagar");
		Person person1 = new Person(2, "Amrendra", "Kushal");
		List<Person> list = new ArrayList<Person>();
		list.add(person);
		list.add(person1);

		when(personRepo.findAll()).thenReturn(list);
		assertEquals(2, personService.getAllPerson().size());
	}
	
	//test to create Person resultss is save or not 
	@Test
	public void saveUserTest() {
		Person person = new Person(1, "Bahubali", "Nagar");
		when(personRepo.save(person)).thenReturn(person);
		assertEquals(person, personService.createPerson(person));
	}
	
	//test to add Dummy PersonByName and check by its size its increses or not 
	 @Test
		public void getPersonByName() {
			String name = "Harsh";
			when(personRepo.findByPersonName(name)).thenReturn(Stream.of(new Person(1,"Harsh","Indore")).collect(Collectors.toList()));
			assertEquals(1, personService.getPersonName(name).size());
		}
	
	
	//test to  Person delete is working or not
	 @Test
	   //@Disabled
		public void deletePerson() {
			Person person = new Person(1,"Harsh","Indore");
			personService.getPersonDelete(person.getPersonId());
			verify(personRepo).deleteById(1);
		}
}

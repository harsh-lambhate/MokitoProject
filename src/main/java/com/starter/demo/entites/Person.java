package com.starter.demo.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	@Id
	 private Integer personId;
	    private String personName;
	    private String personCity;

}

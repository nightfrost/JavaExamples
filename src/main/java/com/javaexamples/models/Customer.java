package com.javaexamples.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/*
 * @Getter, @Setter and @NoArgsConstructor @AllArgsConstructor comes from project Lombok.
 * Eg. import lombok.Getter; 
 * 
 * Getter creates getters for all attributes
 * Setter creates setters for all attributes
 * NoArgsConstructor creates a constructor requiring no arguments.
 * AllArgsConstructor creates a constructor requiring all arguments.
 * Fields marked with @NonNull result in null checks on those parameters.
 * 
 * Documentation can be found here:
 * https://projectlombok.org/features/all
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Customer {
	
	private int customerId;
	
	@NonNull
	private String name;
	
	private int age;
	
	@NonNull
	private String street;
	
	@NonNull
	private String city;
	
	private String state;
	
	private int zip;
	
	@NonNull
	private String balance;
	
	@NonNull
	private String email;
	
	private String phone;
	
	//Would like LocalDate/Calender instead... De-serialize error tho... 
	@NonNull
	private String createdAt;
}

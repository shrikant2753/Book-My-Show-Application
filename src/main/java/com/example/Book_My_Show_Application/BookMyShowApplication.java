package com.example.Book_My_Show_Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}
}
/*

	1. getShowsTiming(movieId, theaterId)
	2. getMovie with max no of shows across all theaters
	3. getTheater(movieId)
	4. getUniqueLocationsOfTheater()

 */

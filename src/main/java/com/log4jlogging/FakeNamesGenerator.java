package com.log4jlogging;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.javafaker.Faker;
@Controller
public class FakeNamesGenerator {
	/*
	 * public static void main(String[] args) {
	 * 
	 * // Create an object of Faker class with default locale i.e ENG Faker faker =
	 * new Faker(); // To generate valid random first name
	 * System.out.println("First name is: "+faker.name().firstName()); // To
	 * generate valid random last name
	 * System.out.println("Last name is: "+faker.name().lastName()); // To generate
	 * valid random city name
	 * System.out.println("City name is: "+faker.address().cityName()); // To
	 * generate valid random state name
	 * System.out.println("State name is: "+faker.address().state()); // To generate
	 * valid random country name
	 * System.out.println("Country name is: "+faker.address().country()); // To
	 * generate valid random cell number
	 * System.out.println("Cell number is: "+faker.phoneNumber().cellPhone()); // To
	 * generate valid random animal name
	 * System.out.println("Animal name is: "+faker.animal().name());
	 * 
	 * }
	 */
	
    private static final Logger logger = LogManager.getLogger(FakeNamesGenerator.class);

    
    @GetMapping("/names")
    public String main(Model model) {
    		
    	Faker faker = new Faker();
    	String firstName=faker.name().firstName();
    	String lastName=faker.name().lastName();
    	String city=faker.address().cityName();
    	String state=faker.address().state();
    	String country=faker.address().country();
    	String phoneno=faker.phoneNumber().cellPhone();
    	String currency=faker.currency().code();
    	
    	FakeUsers[] users = {
    			new FakeUsers(firstName, lastName, city, state, country, phoneno, currency)
    	};
    	
        logger.info("Personal Information of User : First Name: {} | Last Name: {} | City: {} | State: {} | Country: {} | Phone Number: {} | Currency: {} ",
        		() -> firstName, () -> lastName, () -> city, () -> state, () -> country, () -> phoneno, () -> currency);
       
        model.addAttribute("user", users);
 
        return "UserDetails"; //view
    }
    
    
    public static final class FakeUsers{
    	private final String firstName;
    	private final String lastName;
    	private final String city;
    	private final String state;
    	private final String country;
    	private final String phoneno;
    	private final String currency;
    	
		public FakeUsers(String firstName, String lastName, String city, String state, String country, String phoneno,
				String currency) {
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.city = city;
			this.state = state;
			this.country = country;
			this.phoneno = phoneno;
			this.currency = currency;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getCity() {
			return city;
		}

		public String getState() {
			return state;
		}

		public String getCountry() {
			return country;
		}

		public String getPhoneno() {
			return phoneno;
		}

		public String getCurrency() {
			return currency;
		}
    	
		
		    	
    }
}

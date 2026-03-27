package utilities;

import java.util.UUID;

import com.github.javafaker.Faker;

public class testdataGenerator {
	
	
	
	static Faker faker=new Faker();
	 public static String generateFirstName() {
	        return faker.name().firstName();
	    }
	 
	 public static String generateLastName() {
	        return faker.name().lastName();
	    }
	
	public static String GeneraterandomEmail() {
		
		return "testuser_" + UUID.randomUUID().toString().substring(0, 5) + "@yopmail.com";
	}
	
	public static String Generaterandompass() {
		
		return "Test@" + UUID.randomUUID().toString().substring(0, 5);
	}

}

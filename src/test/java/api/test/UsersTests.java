package api.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UsersTests {
	Faker faker;
	User userPayload;
	
	public Logger logger;
	@BeforeClass
	public void SetupData() {
		faker=new Faker(new Locale("en-SG"));
		userPayload=new User();
		userPayload.setId(faker.name().firstName());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 12));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		//logs
		logger=LogManager.getLogger(this.getClass());
	
	}
	@Test(priority=1)
	public void testByAddUser() {
		logger.info("executing the testByAddUser method" );
		logger.info("add user requestpayload");
		
		logger.info("username"+ userPayload.getUsername());
		logger.info("firstName"+ userPayload.getFirstName());
	
		Response response=new UserEndPoints().CreateUser(userPayload);
		//response.then().log().all();
		//response.then().extract()
		String responseBody = response.getBody().asString();
		
		logger.info("response of the adduser" +responseBody);
		
		logger.info("executing Completed testByAddUser method" );
		Assert.assertEquals(response.getStatusCode(), 201, "Expected status code to be 201");
		
	}
	
	@Test(priority=2)
	public void testGetbyuserID() {
	
		Response response=UserEndPoints.readUser(this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200, "Expected status code to be 200");
		
	}
	
	@Test(priority=3)
	public void testUpdatebyuserID() {
		userPayload.setId(faker.name().firstName());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 12));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	
		Response response=UserEndPoints.updateUser(this.userPayload.getId(),userPayload);
		response.then().log().all();
		
		
		
	}
	
	@Test(priority=4)
	public void testparitalbyuserID() {
		userPayload.setId(faker.name().firstName());
	    userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 12));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		System.out.println("parital update user id  value is "+this.userPayload.getId());
		Response response=UserEndPoints.paritalupdateUser(this.userPayload.getId(),userPayload);
		response.then().log().all();
	
		
	}
	
	@Test(priority=5)
	public void testdeletebyuserID() {
		System.out.println("delete user id  value is "+this.userPayload.getId());

		Response response=UserEndPoints.deleteUser(this.userPayload.getId());
		response.then().log().all();
		
		
		
	}

}

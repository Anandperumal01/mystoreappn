package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DUserTest {
User userPayload;

//@Test(priority=1,dataProvider="Userdata",dataProviderClass=DataProviders.class)
public void testByCreateUser(String id,String username,String firstName,String lastName,String email,String password,String phone,String userStatus)
 {
		
	userPayload=new User();
	userPayload.setId(id);
	userPayload.setUsername(username);
	userPayload.setFirstName(firstName);
	userPayload.setLastName(lastName);
	userPayload.setEmail(email);
	userPayload.setPassword(password);
	userPayload.setPhone(phone);
	
	Response response=new UserEndPoints().CreateUser(userPayload);
	//response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 201);
}

//@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)

public void testbyReadUser(String id) {
	Response response=UserEndPoints.readUser(id);
	//response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
}

@Test(priority=3,dataProvider="UserNames",dataProviderClass=DataProviders.class)

public void testbyDeleteUser(String id) {
	Response response=UserEndPoints.deleteUser(id);
	//response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
}

}

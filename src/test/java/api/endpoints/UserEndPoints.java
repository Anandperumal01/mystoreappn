package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoints {
public Logger logger;

public Response CreateUser(User Payload) {
	logger=LogManager.getLogger(this.getClass());
		Response response=given()
				.log().all()
		.contentType("application/json")
		.body(Payload)
		.when()
		.post(Routes.post_url);
		
		return response;
		
	}

public static Response readUser(String id) {

	Response response=given()
			.pathParam("id", id)
	.when()
	.get(Routes.get_url);

	return response;
	
}

public static Response updateUser(String id,User Payload) {

	Response response=given()
	.contentType("application/json")
	.pathParam("id", id)
	.body(Payload)
	.when()
	.put(Routes.update_url);
	
	return response;
	
}

public static Response paritalupdateUser(String id,User Payload) {

	Response response=given()
	.contentType("application/json")
	.pathParam("id", id)
	.body(Payload)
	.when()
	.patch(Routes.parital_url);
	
	return response;
	
}

public static Response deleteUser(String id) {

	Response response=given()
			.pathParam("id", id)
	.when()
	.delete(Routes.delete_url);

	return response;
	
}


}

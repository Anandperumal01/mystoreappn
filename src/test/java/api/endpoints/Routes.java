package api.endpoints;
/*
Domain or base url or common url :http://localhost:3000
endpoint url or resource---/user

url-->Domain+endpoint

Create user(post) : http://localhost:3000/user
Get User(Get) :http://localhost:3000/user/{id}
Update User(put) :http://localhost:3000/user/{id}
Delete User(Delete) :http://localhost:3000/user/{id}*/
	
public class Routes {
	// common
	public static String base_url="http://localhost:3000";
	
	//user module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{id}";
	public static String update_url=base_url+"/user/{id}";
	public static String parital_url=base_url+"/user/{id}";
	public static String delete_url=base_url+"/user/{id}";
	
	// Customer
	
	//Product module
	
	

}

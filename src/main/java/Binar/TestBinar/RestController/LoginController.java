package Binar.TestBinar.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Binar.TestBinar.model.Login;
import Binar.TestBinar.model.Response;
import Binar.TestBinar.model.User;
import Binar.TestBinar.model.UserRegistration;

import Binar.TestBinar.services.UserService;

@RestController
public class LoginController 
{
	@Autowired
	UserService userService;
	
	@PostMapping("auth/login")
	public void login(@RequestBody Login login)
	{
		
	}
	
	@PostMapping("/auth/signup")
	public Response<User> signUp(@RequestBody UserRegistration userRegistration)
	{
		User user = userService.register(userRegistration);
		Response<User> response = new Response<>();
		response.setStatus("ok");
		response.setResult(user);
		response.setError(null);
		return response;
	}
}

package Binar.TestBinar.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Binar.TestBinar.model.User;
import Binar.TestBinar.model.UserRegistration;
import Binar.TestBinar.repository.UserRepository;
import Binar.TestBinar.services.UserService;

@Service
public class UserImplementation implements UserService
{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User register(UserRegistration userRegistration) 
	{
		User user = new User();
		user.setName(userRegistration.getName());
		user.setEmail(userRegistration.getEmail());
		user.setPassword(userRegistration.getPassword());
		return userRepository.save(user);
	}
	
}

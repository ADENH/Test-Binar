package Binar.TestBinar.services;

import Binar.TestBinar.model.User;
import Binar.TestBinar.model.UserRegistration;

public interface UserService 
{
	User register(UserRegistration userRegistration);
}

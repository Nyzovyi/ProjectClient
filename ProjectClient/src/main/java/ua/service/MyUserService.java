package ua.service;

import ua.entity.MyUser;

public interface MyUserService {

	MyUser findByLogin(String login);
	
	MyUser findById(int id);
	
	void save(MyUser user);
}

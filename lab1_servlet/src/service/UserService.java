package service;

import model.User;

public class UserService {
	public boolean userAut(User user)
	{
		if(user.getUserName().equals("admin") && user.getPassword().equals("test123"))
			return true;
		else
			return false;
	}

}

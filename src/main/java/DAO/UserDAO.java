package DAO;

import java.util.List;


import Model.User;

public interface UserDAO {
	public int checkUser(String username);
	public int login(String username,String password);
	List<User> getAll();
	User getUserByID(String id);
	void deleteUser(String id);

	public void edit(User user);
	public User getUser(String id);
	public User getUser_username(String username);
}

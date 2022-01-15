package DAO;

import java.util.List;

import Model.Admin;

public interface AdminDAO {
	public int login(String username,String password);
	public int addAdmin(Admin admin);
	public void delete(int id);
	public Admin get(int id);
	public void edit(Admin admin);
	public Admin get(String name);
	public List<Admin> getAll();
}

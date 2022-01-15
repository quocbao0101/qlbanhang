package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.UserDAO;
import JDBC.DBConnect;

import Model.User;

public class UserDaoImpl implements UserDAO{
	Connection conn = DBConnect.getConnect();
	
	public void addUser(User user)
	{

		String sql = "Insert into users(name,email,phone,username,password) values(?,?,?,?,?)";
		PreparedStatement ps;
		try
		{
			ps = (PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.executeUpdate();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public int checkUser(String username) {
		User user = new User();
		int status = 0;

		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();			

			while (rs.next()) {
				user.setName(rs.getString("name"));
				status = 1;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return status;
	}
	@Override
	public int login(String username , String password)
	{
		User user = new User();
		int status = 0;
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				status = 1;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return status;
		
	}

	@Override
	public List<User> getAll() {
		List<User> cates = new ArrayList<User>();
		String sql = "Select * from users";
		Connection conn = DBConnect.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User cate = new User();
				cate.setId(rs.getString("id"));
				cate.setName(rs.getString("name"));
				cate.setEmail(rs.getString("email"));
				cate.setPhone(rs.getString("phone"));
				cate.setUsername(rs.getString("username"));
				cate.setPassword(rs.getString("password"));
				cate.setCreated(rs.getString("created"));
				
				cates.add(cate);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cates;
	}

	@Override
	public User getUserByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void edit(User user) { 
	String sql = "Update users set name =?, email =?, phone =? , password = ? , created = CURRENT_TIMESTAMP where id=?";

		Connection conn = DBConnect.getConnect();
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(5, user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		 
	} 

	@Override
	public void deleteUser(String id) {
		String query ="delete from users where id = ?";
		try {
			new DBConnect();
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			
		}
		catch (Exception e) {}
	}

	public void addUser( String name, String email, String phone, String username, String password) {
		String sql = "Insert into users(name,email,phone,username,password) values(?,?,?,?,?)";
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, username);
			ps.setString(6, password);
			ps.executeUpdate();
		}
		catch(Exception e)
		{}
	}
	@Override
	public User getUser(String id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		Connection con = DBConnect.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));;
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setCreated(rs.getString("created"));
				user.setPhone(rs.getString("phone"));
				return user;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser_username(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		Connection con = DBConnect.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));;
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setCreated(rs.getString("created"));
				user.setPhone(rs.getString("phone"));
				return user;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}

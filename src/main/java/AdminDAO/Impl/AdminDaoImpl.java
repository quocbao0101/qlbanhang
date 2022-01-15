package AdminDAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.AdminDAO;
import JDBC.DBConnect;
import Model.Admin;


public class AdminDaoImpl implements AdminDAO{
	

	@Override
	public int addAdmin(Admin admin) {
		int status = 0;
		Connection conn = DBConnect.getConnect();
		String sql = "INSERT INTO admin(username,password,name) values(?,?,?)";		
		PreparedStatement ps;
		try
		{
			ps = (PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getName());
			ps.executeUpdate();
			conn.close();
			status = 1;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public void delete(int id) { 		
		String sql = "Delete from admin where id=?";
		Connection conn = DBConnect.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	} 
	@Override
	public Admin get(int id) {		
		Admin admin = new Admin();
		String sql = "SELECT * FROM admin WHERE id=?";
		Connection conn = DBConnect.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));

				return admin;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void edit(Admin admin) { 
	String sql = "Update admin set username =?, password =?, name =? where id=?";

		Connection conn = DBConnect.getConnect();
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(4, admin.getId());
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		 
	} 
	@Override
	public Admin get(String name) { 
		return null; 
	} 
	@Override
	public List<Admin> getAll() { 
		List<Admin> admins = new ArrayList<Admin>(); 
		String sql = "SELECT * FROM admin"; 
		Connection conn = DBConnect.getConnect();
 
		try { 
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery(); 
 
			while (rs.next()) { 
				Admin admin = new Admin(); 
 
				admin.setId(rs.getInt("id")); 
				admin.setUsername(rs.getString("username")); 
				admin.setPassword(rs.getString("password")); 
				admin.setName(rs.getString("name")); 
				admins.add(admin); 
			} 
 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
 
		return admins; 
	}
	@Override
	public int login(String username, String password) {
		Admin admin = new Admin(); 
		int status = 0;
		String sql = "SELECT * FROM admin where username = ? AND password = ?";
		Connection conn = DBConnect.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));

				status = 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;	
		
		
	}
	

}

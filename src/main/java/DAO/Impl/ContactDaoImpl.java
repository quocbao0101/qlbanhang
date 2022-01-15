package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ContactDAO;
import JDBC.DBConnect;
import Model.Contact;

public class ContactDaoImpl implements ContactDAO{

	@Override
	public List<Contact> getAll() {
		List<Contact> contacts = new ArrayList<Contact>();
		String sql = "SELECT * from contact";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Contact contact = new Contact();
				contact.setId(rs.getString("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
				contact.setComment(rs.getString("comment"));
				contacts.add(contact);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public void addContact(Contact contact) {
		Connection conn = DBConnect.getConnect();
		String sql = "INSERT INTO contact(name,email,phone,comment) values(?,?,?,?)";		
		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getEmail());
			ps.setString(3, contact.getPhone());
			ps.setString(4, contact.getComment());

			ps.executeUpdate();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void deleteContact(String id) {
		String query ="delete from contact where id = ?";
		try {
			new DBConnect();
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			
		}
		catch (Exception e) {}
		
	}
}

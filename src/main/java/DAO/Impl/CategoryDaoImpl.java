package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CategoryDAO;
import JDBC.DBConnect;
import Model.Category;


public class CategoryDaoImpl implements CategoryDAO{

	@Override
	public List<Category> getAll() {
		List<Category> cates = new ArrayList<Category>();
		String sql = "Select * from category";
		Connection conn = DBConnect.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Category cate = new Category();
				cate.setId(rs.getInt("id"));
				cate.setName_category(rs.getString("name_category"));
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
	
	
		public void deleteCategory(String id) {
			String query ="delete from category where id = ?";
			try {
				new DBConnect();
				Connection conn = DBConnect.getConnect();
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, id);
				ps.executeUpdate();
				
			}
			catch (Exception e) {}
		}

	@Override
	public void addCategory(String name) {
		String query ="Insert into category(name_category) values(?)";
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void editCategory(String id, String name) {
		String query= "Update category set name_category =? where id=?";
		try {
			Connection conn = DBConnect.getConnect();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.executeUpdate();
		}
		catch(Exception e)
		{}
	}

	@Override
	public Category getCategoryByID(String id) {
		Category category = new Category();
		String sql = "SELECT * FROM category WHERE id=?";
		Connection conn = DBConnect.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				category.setId(rs.getInt("id"));
				
				category.setName_category(rs.getString("name_category"));

				return category;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
	
		
	



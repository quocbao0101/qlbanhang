package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ProductDAO;
import JDBC.DBConnect;

import Model.Product;



public class ProductDaoImpl implements ProductDAO{
	@Override
	public void add(Product product) {
		Connection conn = DBConnect.getConnect();
		String sql = "INSERT INTO product(catalog_id,name,price,status,description,image_link,quantity) values(?,?,?,?,?,?,?)";		
		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getCatalog_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getPrice());
		
			ps.setInt(4, product.getStatus());
			ps.setString(5, product.getDescription());
	
			ps.setString(6, product.getImage_link());
			ps.setInt(7, product.getQuantity());
			ps.executeUpdate();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setStatus(rs.getInt("status"));
				product.setDescription(rs.getString("description"));				
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);			
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getProductById(int id) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE catalog_id=?";
		Connection conn = DBConnect.getConnect();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setStatus(rs.getInt("status"));
				product.setDescription(rs.getString("description"));				
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public Product get(int id) {
		String sql = "SELECT * FROM product,category WHERE product.id = ? AND category.id = product.catalog_id ";
		Connection con = DBConnect.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setStatus(rs.getInt("status"));
				product.setDescription(rs.getString("description"));				
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				product.setName_category(rs.getString("name_category"));
				return product;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void xoasp(int id) {
		String sql = "Delete from product where id=?";
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
	public void edit(Product product) { 
	String sql = "Update product set catalog_id =?, name =?, price =?, status =?, description=?, image_link =?,quantity =? Where id=?";

		Connection conn = DBConnect.getConnect();
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(1, product.getCatalog_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getPrice());
		
			ps.setInt(4, product.getStatus());
			ps.setString(5, product.getDescription());
			
			ps.setString(6, product.getImage_link());
			ps.setInt(7, product.getQuantity());
			ps.setString(8, product.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getsp(String id_product) {
		int qty = 0;
		String sql = "SELECT quantity from product WHERE id = ?";
		Connection conn = DBConnect.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id_product);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product product = new Product();
				qty = product.set_Quantity(rs.getInt("quantity"));
				return qty;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return qty;
	}

	@Override
	public List<Product> getsp() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product ORDER BY quantity ASC";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setStatus(rs.getInt("status"));
				product.setDescription(rs.getString("description"));				
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);			
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> search(String name) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE name LIKE ? ";
		Connection conn = DBConnect.getConnect();
		try
		{
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setStatus(rs.getInt("status"));
				product.setDescription(rs.getString("description"));				
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
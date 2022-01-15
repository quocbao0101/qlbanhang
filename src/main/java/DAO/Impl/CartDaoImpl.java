package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CartDAO;
import JDBC.DBConnect;
import Model.Cart;


public class CartDaoImpl implements CartDAO{

	@Override
	public void insert(Cart cart) {
		String sql = "INSERT INTO cart(username,id_product,qty,price) values(?,?,?,?)";
		Connection conn = DBConnect.getConnect();
		try
		{
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cart.getUsername());
			ps.setString(2,cart.getId_product());
			ps.setInt(3,cart.getQty());
			ps.setString(4,cart.getPrice());
			ps.executeUpdate();
			conn.close();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public int checkCart(String username,String id_product)
	{
		int status = 1;
		String sql = "SELECT * FROM cart WHERE username = ? AND id_product = ?";
		Connection conn = DBConnect.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, id_product);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Cart cart = new Cart();
				cart.setUsername(rs.getString("username"));
				cart.setId_product(rs.getString("id_product"));
				cart.setPrice(rs.getString("price"));
				cart.setQty(rs.getInt("qty"));
				status = 0;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(String username, String id_product) {
		String sql = "UPDATE cart,product SET qty = qty + 1 , cart.price = product.price * qty WHERE username = ? AND id_product = ? AND cart.id_product = product.id";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, id_product);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public List<Cart> getCart(String username) {

		List<Cart> carts = new ArrayList<Cart>();
		String sql = "SELECT * FROM cart,product WHERE cart.id_product = product.id AND username = ?";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cart cart = new Cart();
				cart.setUsername(rs.getString("username"));
				cart.setId_product(rs.getString("id_product"));
				cart.setPrice(rs.getString("price"));
				cart.setQty(rs.getInt("qty"));
				cart.setName(rs.getString("name"));
				cart.setImage_link(rs.getString("image_link"));
				cart.setId(rs.getString("id"));
				
				carts.add(cart);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return carts;
		
	}
	@Override
	public int sumPrice(String username) {
		String sql = "SELECT SUM(price) as sumPrice from cart where username = ?";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Cart cart = new Cart();
				double sumPrice = cart.setSumPrice(rs.getDouble("sumPrice"));
				return (int) sumPrice;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	@Override
	public void xoa(String username, String id_product) {
		String sql ="DELETE from cart WHERE username = ? AND id_product = ?";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, id_product);
			ps.executeUpdate();
		} 
		catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	@Override
	public void updateCart(int qty,String username,String id_product) {
		String sql = "UPDATE cart,product SET qty = ? , cart.price = product.price * qty WHERE username = ? AND id_product = ? AND cart.id_product = product.id";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,qty);
			ps.setString(2,username);
			ps.setString(3, id_product);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public int getCart_qty(String username, String id_product) {
		int qty = 0;
		String sql = "SELECT qty from cart WHERE username = ? AND id_product = ?";
		Connection conn = DBConnect.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, id_product);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Cart cart = new Cart();
				qty = cart.set_Qty(rs.getInt("qty"));
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
	public void updateplusCart(int qty,String username, String id_product) {
		String sql = "UPDATE cart,product SET qty = qty + ? , cart.price = product.price * qty WHERE username = ? AND id_product = ? AND cart.id_product = product.id";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, qty);
			ps.setString(2, username);
			ps.setString(3, id_product);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}	

}

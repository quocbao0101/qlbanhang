package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.TransactionDAO;
import JDBC.DBConnect;
import Model.Product;
import Model.Transactions;

public class TransactionsDaoImpl implements TransactionDAO{

	@Override
	public void themhoadon(Transactions trans) {
		String sql = "INSERT INTO transactions(username,email,phone,address,message,amount,status) values(?,?,?,?,?,?,1)";
		Connection conn = DBConnect.getConnect();
		try
		{
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,trans.getUsername());
			ps.setString(2,trans.getEmail());
			ps.setString(3, trans.getPhone());
			ps.setString(4,trans.getAddress());
			ps.setString(5,trans.getMessage());
			ps.setInt(6,trans.getAmount());
			ps.executeUpdate();
			conn.close();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void xoasp_cart(String id) {
		String sql = "DELETE FROM cart where username = ?";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updatesp(Product product) {
		String sql = "UPDATE product,cart SET quantity = quantity - cart.qty WHERE product.id = cart.id_product AND product.id = ?";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getId());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		


	}


	

}

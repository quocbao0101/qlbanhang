package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.OrderManagerDAO;
import JDBC.DBConnect;
import Model.DetailsManager;
import Model.DetailsProduct;
import Model.OrderManager;


public class OrderManagerImpl implements OrderManagerDAO{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public List<OrderManager> getAll() {
		List<OrderManager> list = new ArrayList<>();
		String query = "SELECT id, username,address, created,status from transactions ORDER BY status ASC";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderManager(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDate(4),
						rs.getString(5)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public DetailsManager getOrderManagerByID(String id) {
		
		String query = "SELECT * FROM transactions WHERE id=?";
		
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DetailsManager(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7), 
						rs.getDate(8));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<DetailsProduct> getByID(String transaction_id)
	{
		List<DetailsProduct> dts = new ArrayList<DetailsProduct>();
		String query = "SELECT name, qty, price from product, ordered WHERE product.id = ordered.product_id AND transaction_id=?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, transaction_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				dts.add(new DetailsProduct(rs.getString(1),rs.getInt(2),rs.getInt(3)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return dts;
		
	}

	@Override
	public void accept(String id) {
		String sql = "UPDATE transactions set status = 1 WHERE id = ?";
		conn = DBConnect.getConnect();
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void huy(String id)
	{
			String sql = "UPDATE transactions set status = 0 WHERE id = ?";
			conn = DBConnect.getConnect();
		try
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}

			
		

	



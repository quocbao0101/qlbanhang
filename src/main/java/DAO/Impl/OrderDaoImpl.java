package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.OrderDAO;
import JDBC.DBConnect;
import Model.Ordered;
import Model.Transactions;

public class OrderDaoImpl implements OrderDAO{

	@Override
	public void insert(List<Ordered> ordered,int id_trans) {
		String sql = "INSERT INTO ordered(product_id,transaction_id,qty) values(?,?,?)";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			for(Ordered order :ordered)
			{
				ps.setString(1, order.getPid());	
				ps.setInt(2, id_trans);
				ps.setString(3, order.getQty());
				ps.executeUpdate();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public int getid_Transaction(String username, int amount) {
		int id = 0;
		String sql = "SELECT id from transactions WHERE username = ? AND amount = ?";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, amount);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Transactions trans = new Transactions();
				id = trans.setId_trans(rs.getInt("id"));
				return id;
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return id;
		
	}
	
	
}

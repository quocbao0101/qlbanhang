package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.HistoryDAO;
import JDBC.DBConnect;
import Model.History;

public class HistoryDaoImpl implements HistoryDAO{

	@Override
	public List<History> getAll(String username) {
		List<History> historys = new ArrayList<>();
		String sql = "SELECT * from transactions WHERE username = ? ORDER BY created DESC";
		Connection conn = DBConnect.getConnect();
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				History history = new History();
				history.setId(rs.getString("id"));
				history.setAmount(rs.getString("amount"));
				history.setStatus(rs.getString("status"));
				history.setCreated(rs.getString("created"));
				historys.add(history);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return historys;
	}

}

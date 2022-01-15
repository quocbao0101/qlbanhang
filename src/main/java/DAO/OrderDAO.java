package DAO;

import java.util.List;

import Model.Ordered;

public interface OrderDAO {
	public void insert(List<Ordered> ordered,int id_trans);
	public int getid_Transaction(String username , int amount);
	
}

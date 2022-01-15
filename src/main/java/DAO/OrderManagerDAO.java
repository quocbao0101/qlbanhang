package DAO;

import java.util.List;

import Model.DetailsManager;
import Model.DetailsProduct;
import Model.OrderManager;



public interface OrderManagerDAO {
	public List<OrderManager> getAll();
	public DetailsManager getOrderManagerByID(String id);
	public List<DetailsProduct> getByID(String transaction_id);
	public void accept(String id);
	public void huy(String id);
}

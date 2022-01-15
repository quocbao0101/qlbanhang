package DAO;

import java.util.List;

import Model.Cart;

public interface CartDAO {
	public void insert(Cart cart);
	public void delete(int id);
	public int checkCart(String username,String id_product);
	public void update(String username,String id_product);
	public List<Cart> getCart(String username);
	public int sumPrice(String username);
	public void xoa(String username,String id_product);
	public void updateCart(int qty,String username,String id_product);
	public int getCart_qty(String username,String id_product);
	void updateplusCart(int qty, String username, String id_product);

}

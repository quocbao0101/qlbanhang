package DAO;

import java.util.List;


import Model.Product;

public interface ProductDAO {
	public List<Product> getAll();
	public List<Product> getsp();


	public List<Product> getProductById(int id);

	
	public void xoasp(int id);
	public Product get(int id);
	public void edit(Product product);
	public int getsp(String id);
	public void add(Product product);
	public List<Product> search(String name);
}

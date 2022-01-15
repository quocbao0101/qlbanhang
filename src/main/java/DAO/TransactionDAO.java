package DAO;



import Model.Product;
import Model.Transactions;

public interface TransactionDAO {
	public void themhoadon(Transactions trans);
	public void xoasp_cart(String id);
	public void updatesp(Product product);


}

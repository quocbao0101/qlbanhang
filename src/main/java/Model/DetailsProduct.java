package Model;

public class DetailsProduct {
	public DetailsProduct()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String name;
	public int qty;
	public int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public DetailsProduct(String name, int qty, int price) {
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
}

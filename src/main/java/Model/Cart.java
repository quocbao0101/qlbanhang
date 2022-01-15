package Model;






public class Cart {	
	public Cart() {
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	public int set_Qty(int qty)
	{
		return this.qty = qty;
	}
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public double setSumPrice(double sumPrice) {
		return this.sumPrice = sumPrice;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	private String id;
	private String username;
	private String id_product;
	private int qty;
	private String price;
	private double sumPrice;
	private String created;
	
	
	// product
	private String name;
	private String image_link;
	public Cart(String username,String id_product,int qty,String price)
	{
		this.username = username;
		this.id_product = id_product;
		this.qty = qty;
		this.price = price;		
	}
	public Cart(String username,String id_product,int qty,String price,String name,String image_link)
	{
		this.username = username;
		this.id_product = id_product;
		this.qty = qty;
		this.price = price;
		this.name = name;
		this.image_link = image_link;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}


}

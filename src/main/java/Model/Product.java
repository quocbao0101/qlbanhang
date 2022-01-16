package Model;

public class Product {
	public Product() {};
	public Product(String catalog_id,String name,String price,  String description, String image_link, int quantity)
	{
		this.catalog_id = catalog_id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image_link = image_link;
		this.quantity = quantity;
	}

	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int set_Quantity(int quantity)
	{
		return this.quantity = quantity;
	}
	public String getName_category() {
		return name_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}



	public int getId_get() {
		return id_get;
	}
	public int setId_get(int id_get) {
		return this.id_get = id_get;
	}



	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}



	private String id;
	private int id_get;
	private String catalog_id;
	private String name_category;
	private String name;
	private String price;
	private int quantity;
	private int status;
	private String description;
	private String image_link;
	private String created;
	private String qty;

}

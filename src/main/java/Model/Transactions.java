package Model;

public class Transactions {

	
	private int id_trans;
	private String id;
	private String username;
	private String email;
	private String phone;
	private String address;
	private String message;
	private int amount;
	private String created;
	public Transactions()
	{
		
	}
	public Transactions(String username, String email, String address, String phone, String message,
			int amount) 
	{
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.message = message;
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getId_trans() {
		return id_trans;
	}
	public int setId_trans(int id_trans) {
		return this.id_trans = id_trans;
	}
}

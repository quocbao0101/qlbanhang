package Model;

import java.sql.Date;

public class OrderManager {
	public int id;
	public OrderManager(int id,String username, String address,  Date  created,String status) {
		this.id = id;
		this.username = username;
		
		this.address = address;
		this.created = created;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String username;
	public String address;
	public Date created;
	public String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

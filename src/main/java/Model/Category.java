package Model;

public class Category {
	private int id;
	private String name_category;

	public Category()
	{
		
	}
	public Category(int id,String name_category)
	{
		this.id = id;
		this.name_category = name_category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_category() {
		return name_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}

	
}

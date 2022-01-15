package DAO;

import java.util.List;


import Model.Category;

public interface CategoryDAO {
	public List<Category> getAll();

	public void deleteCategory(String id);
	public void addCategory(String name);
	public void editCategory(String id, String name);
	public Category getCategoryByID(String id);
}

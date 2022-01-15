package DAO;

import java.util.List;

import Model.Contact;

public interface ContactDAO {
	public List<Contact> getAll();
	public void addContact(Contact contact);
}

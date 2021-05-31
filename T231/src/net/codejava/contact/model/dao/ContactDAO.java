package net.codejava.contact.model.dao;

import java.util.List;

import net.codejava.contact.model.Contact;

public interface ContactDAO {
	public int save(Contact c);

	public int update(Contact c);

	public Contact get(Integer id);

	public int delete(Integer id);

	public List<Contact> list();

}

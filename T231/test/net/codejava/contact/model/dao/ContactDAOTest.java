package net.codejava.contact.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("rooot");
		
		dao = new ContactDAOImpl(dataSource);
	}
	

	@Test
	void testSave() {
		
		Contact  contact = new Contact("Bill Gates", "billy@microsoft.com", "tempe, WA", "343245");
		int result = dao.save(contact);
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		Contact  contact = new Contact(2, "New man", "newy@microsoft.com", "Canada, WA", "54321");
		int result = dao.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Contact contact = dao.get(id);
		if (contact!=null)
			System.out.println(contact.toString());
		
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id=2;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> listContact = dao.list();
		for(Contact contact : listContact)
			System.out.println(contact.toString());
		assertTrue(!listContact.isEmpty());
	}

}

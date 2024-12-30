package com.devpro.yuubook.services;

import com.devpro.yuubook.models.entities.Contact;

import java.util.List;

public interface ContactService {
	Contact save(Contact contact);

	List<Contact> getAll();

	void deleteById(Integer id);
}

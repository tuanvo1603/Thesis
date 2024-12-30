package com.devpro.yuubook.services.impl;

import com.devpro.yuubook.models.entities.Contact;
import com.devpro.yuubook.repositories.ContactRepo;
import com.devpro.yuubook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepo contactRepo;

    @Override
    public Contact save(Contact contact) {
        contact.setCreatedDate(LocalDateTime.now());
        contact.setStatus(true);
        return contactRepo.save(contact);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        contactRepo.deleteById(id);
    }
}

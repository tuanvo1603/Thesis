package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
}
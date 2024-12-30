package com.devpro.yuubook.services;

import com.devpro.yuubook.models.dto.AuthorDTO;
import com.devpro.yuubook.models.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    List<AuthorDTO> getAuthorWithLimitedProduct(int l);

    List<Author> getAll();

    Author getBySlug(String slug);
}

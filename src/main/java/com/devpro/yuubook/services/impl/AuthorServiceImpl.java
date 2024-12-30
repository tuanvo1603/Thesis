package com.devpro.yuubook.services.impl;

import com.devpro.yuubook.models.dto.AuthorDTO;
import com.devpro.yuubook.models.entities.Author;
import com.devpro.yuubook.repositories.AuthorRepo;
import com.devpro.yuubook.services.AuthorService;
import com.devpro.yuubook.services.mappers.AuthorMapper;
import com.devpro.yuubook.utils.FileUtils;
import com.devpro.yuubook.utils.FuncUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> getAuthorWithLimitedProduct(int limit) {
        List<Author> authors = authorRepo.getAllAuthorWithProductOrderByCreateDateDesc();
        return authorMapper.toDTO(authors, limit);
    }

    public List<Author> getAll() {
        return authorRepo.findAll();
    }

    @Override
    public Author getBySlug(String slug) {
        return authorRepo.findBySlug(slug);
    }
}

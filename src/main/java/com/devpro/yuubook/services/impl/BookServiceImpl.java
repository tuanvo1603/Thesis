package com.devpro.yuubook.services.impl;

import com.devpro.yuubook.models.entities.Book;
import com.devpro.yuubook.repositories.BookRepo;
import com.devpro.yuubook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getLimitedProductsHot(int limit) {
        return bookRepo.getLimitedProductsHot(limit);
    }

    @Override
    public List<Book> searchBooksByKeyword(String keyword) {
        return bookRepo.getAllBookByKeyword(keyword.trim());
    }
}

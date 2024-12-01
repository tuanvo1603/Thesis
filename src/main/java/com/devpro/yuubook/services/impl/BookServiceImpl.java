package com.devpro.yuubook.services.impl;

import com.devpro.yuubook.models.dto.BookDTO;
import com.devpro.yuubook.models.entities.Book;
import com.devpro.yuubook.repositories.BookRepo;
import com.devpro.yuubook.services.BookService;
import com.devpro.yuubook.services.mappers.BookMapper;
import com.devpro.yuubook.utils.FuncUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getLimitedProductsHot(int limit) {
        return bookRepo.getLimitedProductsHot(limit);
    }

    @Override
    public List<Book> searchBooksByKeyword(String keyword) {
        return bookRepo.getAllBookByKeyword(keyword.trim());
    }

    @Override
    public List<BookDTO> ajaxSearchBooksByKeyword(String keyword, int limit) {
        List<Book> books = bookRepo.getAllBookByKeyword(keyword.trim());
        return bookMapper.toDTO(books, limit);
    }

    @Override
    public Book getBySlug(String slug) {
        Book book = bookRepo.findBySlug(slug);
        book.setStarAvg(FuncUtils.calculatorStar(book));
        return book;
    }
}

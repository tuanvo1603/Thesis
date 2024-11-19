package com.devpro.yuubook.services;

import com.devpro.yuubook.models.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> getLimitedProductsHot(int limit);

    List<Book> searchBooksByKeyword(String keyword);
}

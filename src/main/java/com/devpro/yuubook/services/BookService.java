package com.devpro.yuubook.services;

import com.devpro.yuubook.models.dto.BookDTO;
import com.devpro.yuubook.models.entities.Author;
import com.devpro.yuubook.models.entities.Book;
import com.devpro.yuubook.models.entities.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    List<Book> getLimitedProductsHot(int limit);

    List<Book> searchBooksByKeyword(String keyword);

    List<BookDTO> ajaxSearchBooksByKeyword(String keyword, int limit);

    Book getBySlug(String slug);

    Page<Book> getAllByCategoryAndSort(Category category, int currentPage, String sortBy, int recordsPerPage);

    Book getById(Integer id);

    Page<Book> getAllByAuthorAndSort(Author author, int currentPage, String sortBy, int recordsPerPage);
}

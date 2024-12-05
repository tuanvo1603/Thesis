package com.devpro.yuubook.services.impl;

import com.devpro.yuubook.models.dto.BookDTO;
import com.devpro.yuubook.models.entities.Book;
import com.devpro.yuubook.models.entities.Category;
import com.devpro.yuubook.repositories.BookRepo;
import com.devpro.yuubook.services.BookService;
import com.devpro.yuubook.services.mappers.BookMapper;
import com.devpro.yuubook.utils.FuncUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<Book> getAllByCategoryAndSort(Category category,
                                              int currentPage,
                                              String sortBy,
                                              int recordsPerPage) {
        Pageable pageable = PageRequest.of(currentPage - 1, recordsPerPage, setSort(sortBy));

        if (category == null)
            return bookRepo.getAllByHot(pageable);

        return bookRepo.getAllByCategory(category.getId(), pageable);
    }

    public Sort setSort(String sortBy) {
        Sort sort;
        switch (sortBy) {
            case "az":
                sort = Sort.by("name").ascending();
                break;
            case "za":
                sort = Sort.by("name").descending();
                break;
            case "minmax":
                sort = Sort.by("price").ascending();
                break;
            case "maxmin":
                sort = Sort.by("price").descending();
                break;
            default:
                sort = Sort.by("created_date").descending();
                break;
        }
        return sort;
    }
}

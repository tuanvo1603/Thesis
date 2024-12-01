package com.devpro.yuubook.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.devpro.yuubook.utils.FuncUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devpro.yuubook.utils.Constant;
import com.devpro.yuubook.models.entities.Book;
import com.devpro.yuubook.models.entities.Category;
import com.devpro.yuubook.models.entities.Comment;
import com.devpro.yuubook.services.AuthorService;
import com.devpro.yuubook.services.BookService;
import com.devpro.yuubook.services.CategoryService;

@Controller
public class ProductController extends BaseController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String author() {
        return "author";
    }

    @GetMapping("/san-pham/{slug}")
    public String singleProduct(ModelMap model, @PathVariable("slug") String slug) {
        model.addAttribute("categories", categoryService.getAllParentCategories());
        model.addAttribute("book", bookService.getBySlug(slug));
        return "single-product";
    }
}

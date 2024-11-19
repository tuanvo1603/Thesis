package com.devpro.yuubook.controllers;

import com.devpro.yuubook.models.dto.AjaxResponse;
import com.devpro.yuubook.models.dto.BookDTO;
import com.devpro.yuubook.services.AuthorService;
import com.devpro.yuubook.services.BookService;
import com.devpro.yuubook.services.CategoryService;
import com.devpro.yuubook.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HomeController extends BaseController{
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "/home"})
    public String index(ModelMap model) throws Exception {
        model.addAttribute("authors",
                authorService.getAuthorWithLimitedProduct(Constant.HOME_LIMITED_PRODUCT_AUTHOR));
        model.addAttribute("bookHot",
                bookService.getLimitedProductsHot(Constant.HOME_LIMITED_PRODUCT_HOT));
        model.addAttribute("subCateShowHome",
                categoryService.getSubCategoryWithLimitedProduct(Constant.HOME_LIMITED_PRODUCT_SUBCATEGORY));
        model.addAttribute("parentCateShowHome",
                categoryService.getParentCategoryWithLimitedProduct(Constant.HOME_LIMITED_PRODUCT_CATEGORY));
        return "index";
    }

    @GetMapping("/search")
    public String searchProduct(ModelMap model, @RequestParam("q") String keyword) {
        model.addAttribute("books", bookService.searchBooksByKeyword(keyword));
        model.addAttribute("keyword", keyword);
        return "product-search";
    }

    @GetMapping("/search-suggest")
    public ResponseEntity<AjaxResponse> searchProductByAjax(ModelMap model, @RequestParam("q") String keyword) {
        List<BookDTO> books = bookService.ajaxSearchBooksByKeyword(keyword, 10);
        return ResponseEntity.ok(new AjaxResponse(books, 200));
    }
}

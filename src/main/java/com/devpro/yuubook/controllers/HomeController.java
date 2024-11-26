package com.devpro.yuubook.controllers;

import com.devpro.yuubook.services.AuthorService;
import com.devpro.yuubook.services.BookService;
import com.devpro.yuubook.services.CategoryService;
import com.devpro.yuubook.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


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
}

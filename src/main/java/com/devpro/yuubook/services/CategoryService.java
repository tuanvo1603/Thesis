package com.devpro.yuubook.services;

import com.devpro.yuubook.models.dto.CategoryDTO;
import com.devpro.yuubook.models.entities.Category;

import java.util.List;

public interface CategoryService {

	List<CategoryDTO> getSubCategoryWithLimitedProduct(int limit);
	
	List<CategoryDTO> getParentCategoryWithLimitedProduct(int limit);
}

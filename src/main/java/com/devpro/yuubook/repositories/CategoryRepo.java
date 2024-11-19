package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query("From Category c where c.parentId.id is null")
    List<Category> findAllParentCategories();

	@Query("select distinct c from Category c left join fetch c.books b where c.id = b.category.id "
			+ "order by c.createdDate asc, b.createdDate desc")
	List<Category> getAllSubCategoryWithProduct();
}

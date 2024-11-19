package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookRepo extends JpaRepository<Book, Integer> {
	@Query(value = "select * from book where status = 1 order by created_date desc", nativeQuery = true)
	List<Book> getAll();

	@Query(value = "select * from book where hot = 1 and status = 1 order by created_date desc limit ?1", nativeQuery = true)
	List<Book> getLimitedProductsHot(int limit);

	@Query("select b from Book b inner join Author a on b.author.id = a.id"
			+ " where concat(b.name, ' ', a.name, ' ') like %?1% and b.status = true")
	List<Book> getAllBookByKeyword(String keyword);
}

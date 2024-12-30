package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

	@Query("select distinct a from Author a left join fetch a.books b  where a.id = b.author.id  and b.status = 1 order by b.createdDate desc")
	List<Author> getAllAuthorWithProductOrderByCreateDateDesc();

	Author findBySlug(String slug);
}

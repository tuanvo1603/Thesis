package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.BookFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookFavoriteRepo extends JpaRepository<BookFavorite, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "delete from book_favorite where user_id = ?1 and book_id = ?2", nativeQuery = true)
	void deleteByUserAndBook(int id, int id2);
}

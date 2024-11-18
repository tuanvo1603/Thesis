package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District, Integer>{
	
	@Query(value = "select * from district where province_id = ?1", nativeQuery = true)
	List<District> getAllById(int id);

}

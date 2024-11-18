package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepo extends JpaRepository<UserAddress, Integer> {

	@Query(value = "select * from user_address where user_id = ?1", nativeQuery = true)
	UserAddress getUserAddressByUserId(int id);
	
}

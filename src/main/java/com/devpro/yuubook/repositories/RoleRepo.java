package com.devpro.yuubook.repositories;

import com.devpro.yuubook.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
	Role findRoleByName(String roleName);
}

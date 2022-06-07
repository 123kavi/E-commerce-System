package com.cylonomic.repository;

import org.springframework.data.repository.CrudRepository;

import com.cylonomic.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByName(String name);

}

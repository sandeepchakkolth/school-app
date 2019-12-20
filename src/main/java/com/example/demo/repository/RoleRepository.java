package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Role;

/**
 * @author sandeep
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);

}

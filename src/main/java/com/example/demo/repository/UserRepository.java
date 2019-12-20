/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

/**
 * @author sandeep
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}

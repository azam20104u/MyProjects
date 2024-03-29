package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<UserDTO, Integer> {

	@Query("from UserDTO where username=:username")
	UserDTO findByUser(String username);

}

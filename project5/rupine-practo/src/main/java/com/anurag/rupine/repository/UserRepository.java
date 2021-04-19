package com.anurag.rupine.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.anurag.rupine.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

	@Query("select u from Users u where u.email=?1")
	Users findByEmail(String email);
}

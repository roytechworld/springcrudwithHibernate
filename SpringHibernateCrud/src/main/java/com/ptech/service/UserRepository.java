/**
 * 
 */
package com.ptech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.ptech.pojo.User;



/**
 * @author pavan.solapure
 *
 */
@Component
public interface UserRepository extends JpaRepository<User, Long> {
	
//	@Query(value = "SELECT * FROM USER", nativeQuery = true)
	List<User> findAllByUsernames(List<String> listOfUsernames);
}

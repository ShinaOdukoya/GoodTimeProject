package com.goodTime.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.goodTime.domainobject.UserResponseObject;
import com.goodTime.model.User;


@Repository
@RepositoryRestResource(collectionResourceRel = "user", path="user", excerptProjection=UserResponseObject.class)
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByBusinessName(String businessName);
	Optional<User> findByEmailAddress(String emailAddress);
	
    Boolean existsByEmailAddress(String email);

	
	//Fetch User By emailAddress or userName
		 @Query("select d from User d where d.userName = :userName or d.emailAddress = :userName")
			User findByUsername(@Param("userName")String userName);
	
}

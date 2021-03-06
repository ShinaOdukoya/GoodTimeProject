package com.goodTime.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.goodTime.demainobject.UserResponseObject;
import com.goodTime.model.User;


@Repository
@RepositoryRestResource(collectionResourceRel = "users", path="users", excerptProjection=UserResponseObject.class)
public interface UserRepository extends JpaRepository<User, UUID> {
	
	User findByBusinessName(String businessName);
	User findByEmailAddress(String emailAddress);
	
}

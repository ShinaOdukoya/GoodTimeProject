package com.goodTime.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goodTime.userDTO.UserDto;

@Repository
public interface UserJpaRepository extends JpaRepository<UserDto, Long> {
	
	UserDto findByBusinessName(String businessName);
}

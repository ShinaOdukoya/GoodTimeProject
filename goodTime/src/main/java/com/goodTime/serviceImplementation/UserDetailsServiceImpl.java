package com.goodTime.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodTime.model.User;
import com.goodTime.repository.UserRepository;
import com.goodTime.securityconfiguration.UserPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	
	 @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {
	        User user = userRepository.findByEmailAddress(email)
	                .orElseThrow(() ->
	                        new UsernameNotFoundException("User not found with email : " + email)
	        );

	        return UserPrincipal.create(user);
	    }

	    @Transactional
	    public UserDetails loadUserByEmail(String email) {
	        User user = userRepository.findByUsername(email);

	        return UserPrincipal.create(user);
	    }
	    
}

package com.goodTime.serviceImplementation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.goodTime.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserServiceImpl userService;

	@Override
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {

		User user = userService.findUserByEmailAddressOrUserName(emailAddress);
		if (user == null)
			throw new UsernameNotFoundException("User with " + emailAddress + " not found");

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				getAuthorities(user));

	}

	private Collection<GrantedAuthority> getAuthorities(User user) {

		Set<GrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;

	}

}

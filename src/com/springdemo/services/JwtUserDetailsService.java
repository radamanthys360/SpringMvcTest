package com.springdemo.services;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springdemo.db.entity.Users;
import com.springdemo.db.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository<Users> userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado: " + username);
		}
		Object[][] findRoles = userRepository.findRoles(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Object[] objects : findRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(objects[0].toString()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(),grantedAuthorities);
	}

}

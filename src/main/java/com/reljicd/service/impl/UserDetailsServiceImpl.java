package com.reljicd.service.impl;

import com.reljicd.model.User;
import com.reljicd.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User with username: %s not found.", username)));
        List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole())).toList();

        return new org.springframework.security.core.userdetails.User(username, appUser.getPassword(), authorities);
    }

}

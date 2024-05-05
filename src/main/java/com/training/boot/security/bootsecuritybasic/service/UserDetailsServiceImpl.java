package com.training.boot.security.bootsecuritybasic.service;

import com.training.boot.security.bootsecuritybasic.entities.DAOUser;
import com.training.boot.security.bootsecuritybasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser daoUser = userRepository.findByUsername(username);
        if (daoUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(daoUser.getUsername(), daoUser.getPassword(), new ArrayList<>());
    }
}

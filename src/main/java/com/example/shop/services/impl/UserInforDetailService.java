package com.example.shop.services.impl;

import com.example.shop.dto.UserInforUserDetails;
import com.example.shop.entities.User;
import com.example.shop.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepo iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserInforUserDetails(user);
    }
}

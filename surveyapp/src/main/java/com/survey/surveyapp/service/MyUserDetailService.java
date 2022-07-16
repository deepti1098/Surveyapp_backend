package com.survey.surveyapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.survey.surveyapp.model.Users;
import com.survey.surveyapp.repos.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByemailId(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid Id");
        }
        return new User(user.getEmailId(), user.getPassword(), new ArrayList<>());
    }

}

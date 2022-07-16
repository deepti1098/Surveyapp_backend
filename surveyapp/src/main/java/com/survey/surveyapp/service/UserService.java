package com.survey.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.survey.surveyapp.model.Users;
import com.survey.surveyapp.repos.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Users> get_all_user() {
        return userrepo.findAll();
    }

    public Users Create_user(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userrepo.save(user);
    }

    public Users getbyemailId(String emailId) {
        return userrepo.findByemailId(emailId);
    }

}

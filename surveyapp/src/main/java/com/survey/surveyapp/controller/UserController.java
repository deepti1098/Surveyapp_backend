package com.survey.surveyapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.surveyapp.Config.JwtUtil;
import com.survey.surveyapp.Dto.AuthenticationRequest;
import com.survey.surveyapp.Dto.AuthenticationResponse;
import com.survey.surveyapp.model.Users;
import com.survey.surveyapp.service.MyUserDetailService;
import com.survey.surveyapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService user_service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public ResponseEntity<List<Users>> GetUsers() {
        List<Users> users = user_service.get_all_user();
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

    // @CrossOrigin("http://localhost:3000")
    @PostMapping("/register")
    public ResponseEntity<Users> Post_newUser(@Valid @RequestBody Users user) {
        Users new_user = user_service.Create_user(user);
        return new ResponseEntity<>(new_user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {

        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("Invalid crendentials");
        }
        UserDetails userDetails = userDetailService.loadUserByUsername(request.getEmail());
        String token = "Bearer " + jwtUtil.createToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @GetMapping("/dd")
    public String abc() {
        return "asd";
    }
}

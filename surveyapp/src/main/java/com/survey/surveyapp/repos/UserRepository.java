package com.survey.surveyapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.surveyapp.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByemailId(String emailId);
}

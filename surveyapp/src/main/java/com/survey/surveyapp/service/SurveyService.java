// package com.survey.surveyapp.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.survey.surveyapp.model.Survey;
// import com.survey.surveyapp.model.Users;
// import com.survey.surveyapp.repos.SurveyRepository;
// // import com.survey.surveyapp.repos.UserRepository;

// @Service
// public class SurveyService {

// // @Autowired
// // private UserRepository userRepository;

// @Autowired
// private SurveyRepository surveyRepository;

// public List<Survey> getAllSurvey() {
// return this.surveyRepository.findAll();

// }

// public Survey addSurvey(Survey survey) {
// survey.setSurveyId(null);
// Survey survey2 = surveyRepository.save(survey);
// return survey2;
// }

// public List<Survey> getSurveyByUser(Users user) {
// return surveyRepository.findByUsers(user);

// }
// }

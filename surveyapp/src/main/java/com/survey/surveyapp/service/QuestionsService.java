// package com.survey.surveyapp.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.survey.surveyapp.model.Questions;
// import com.survey.surveyapp.model.Survey;
// import com.survey.surveyapp.repos.QuestionsRepository;
// import com.survey.surveyapp.repos.SurveyRepository;

// @Service
// public class QuestionsService {

// @Autowired
// private QuestionsRepository questionRepository;

// private SurveyRepository surveyRepository;

// public List<Questions> getAllQuestionBySurvey(Integer surveyId) {
// Survey survey = surveyRepository.findBySurveyId(surveyId);
// List<Questions> questions = questionRepository.findBySurvey(survey);
// return questions;
// }

// public Questions addQuestions(Questions questions) {
// questions.setQuestionId(null);
// Questions questions2 = questionRepository.save(questions);
// return questions2;
// }
// }

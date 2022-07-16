// package com.survey.surveyapp.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.survey.surveyapp.model.Answer;
// import com.survey.surveyapp.model.Questions;
// import com.survey.surveyapp.repos.AnswerRepository;

// @Service
// public class AnswerService {
// @Autowired
// private AnswerRepository answerRepository;

// public Answer getAnswerByQuestion(Questions questions) {
// return answerRepository.findByQuestions(questions);
// }

// public Answer addAnswer(Answer answer) {
// answer.setAnswerId(null);
// return answerRepository.save(answer);

// }
// }

package com.shakir.questionservice.Service;


import com.shakir.questionservice.Entity.Answer;
import com.shakir.questionservice.Entity.Question;
import com.shakir.questionservice.Entity.QuestionWrapper;
import com.shakir.questionservice.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "success";
    }

    public List<Integer> generateQuestionsForQuiz(int qNo, String category) {
        List<Integer> questions=questionRepository.findRandomQuestionsByCategory(category,qNo);
        return questions;
    }

    public List<QuestionWrapper> getQuestionsForQuiz(List<Integer> questionIds) {
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        List<Question> questions=new ArrayList<>();

        for(Integer questionId:questionIds){
            questions.add(questionRepository.findById(questionId).get());
        }
        for(Question question:questions){
            QuestionWrapper wrapper=new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            questionWrappers.add(wrapper);
        }
        return questionWrappers;

    }

    public int checkAnswers(List<Answer> answer) {


        int correct=0;

        for(Answer a:answer){
            Question question=questionRepository.findById(a.getId()).get();
            if(a.getAnswer().equals(question.getAnswer())){
                correct++;
            }
        }

        return correct;
    }
}

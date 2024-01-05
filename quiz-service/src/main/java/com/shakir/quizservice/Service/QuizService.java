package com.shakir.quizservice.Service;


import com.shakir.quizservice.Entity.Answer;
import com.shakir.quizservice.Entity.QuestionWrapper;
import com.shakir.quizservice.Entity.Quiz;
import com.shakir.quizservice.Feign.QuizInterface;
import com.shakir.quizservice.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    QuizInterface quizInterface;


    public String addQuiz(String title, int qNo, String category) {

        List<Integer> questions=quizInterface.generateQuestionsForQuiz(qNo, category);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return "success";
    }

    public List<QuestionWrapper> getQuiz(int id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Integer> questions=quiz.get().getQuestions();
        List<QuestionWrapper> questionWrappers=quizInterface.getQuestionsForQuiz(questions);

        return questionWrappers;

    }

    public int submitQuiz(List<Answer> answer) {

        int score=quizInterface.checkAnswers(answer);

        return score;

    }
}

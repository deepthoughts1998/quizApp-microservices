package com.shakir.quizservice.Feign;

import com.shakir.quizservice.Entity.Answer;
import com.shakir.quizservice.Entity.QuestionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("/question/generate")
    public List<Integer> generateQuestionsForQuiz(@RequestParam int qNo, @RequestParam String category);

    @PostMapping("/question/getquestions")
    public List<QuestionWrapper> getQuestionsForQuiz(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/answers")
    public int checkAnswers(@RequestBody List<Answer> answer);

}

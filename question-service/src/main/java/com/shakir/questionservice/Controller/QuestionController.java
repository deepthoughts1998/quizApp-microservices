package com.shakir.questionservice.Controller;


import com.shakir.questionservice.Entity.Answer;
import com.shakir.questionservice.Entity.Question;
import com.shakir.questionservice.Entity.QuestionWrapper;
import com.shakir.questionservice.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    //This method will fetch a list of question ids for the requested params
    @GetMapping("/generate")
    public List<Integer> generateQuestionsForQuiz(@RequestParam int qNo,@RequestParam String category){
        return questionService.generateQuestionsForQuiz(qNo,category);
    }

    //This method will get all question ids from and return the question wrappers
    @PostMapping("/getquestions")
    public List<QuestionWrapper> getQuestionsForQuiz(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsForQuiz(questionIds);
    }

    @PostMapping("/answers")
    public int checkAnswers(@RequestBody List<Answer> answer){
        return questionService.checkAnswers(answer);
    }
}

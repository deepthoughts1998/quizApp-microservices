package com.shakir.quizservice.Controller;

import com.shakir.quizservice.Entity.Answer;
import com.shakir.quizservice.Entity.QuestionWrapper;
import com.shakir.quizservice.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/add")
    public String addQuiz(@RequestBody QuizDto quizDto){
        return quizService.addQuiz(quizDto.getTitle(),quizDto.getqNo(),quizDto.getCategory());
    }

    @GetMapping("/{id}")
    public List<QuestionWrapper> getQuiz(@PathVariable int id){
        return quizService.getQuiz(id);
    }

    @PostMapping("/submit")
    public int submitQuiz(@RequestBody List<Answer> answer){

        return quizService.submitQuiz(answer);
    }
}

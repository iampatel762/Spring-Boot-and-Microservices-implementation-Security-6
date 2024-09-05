package com.quiz_services.Controller;

import com.quiz_services.Modal.QuestionWrapper;
import com.quiz_services.Modal.Quiz;
import com.quiz_services.Modal.QuizDto;
import com.quiz_services.Modal.Response;
import com.quiz_services.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired(required = true)
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        System.out.println(quizDto);
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitAnswer(@PathVariable int id, @RequestBody List<Response> response){
        return quizService.submitAnswer(id,response);
    }
}

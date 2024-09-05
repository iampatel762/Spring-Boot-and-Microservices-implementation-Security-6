package com.question_services.Controller;


import ch.qos.logback.core.sift.AppenderFactoryUsingSiftModel;
import com.question_services.Modal.McqModal;
import com.question_services.Modal.QuestionWrapper;
import com.question_services.Modal.Response;
import com.question_services.Service.McqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class McqController {

    @Autowired
    private McqService mcqService;

    @GetMapping("allQuestion")
    public List<McqModal> getAllProduct(){
        return mcqService.findAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<McqModal>> getQuestionByCategory(@PathVariable String category){
        return new ResponseEntity<>(mcqService.findQuestionByCategory(category), HttpStatus.OK);
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody McqModal modal){
        mcqService.addQuestion(modal);
        return "successfully added";
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam int numQuestions){
        return mcqService.getQuestionsForQuiz(categoryName,numQuestions);
    }
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionsId){
        return mcqService.getQuestionFromId(questionsId);
    }
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return mcqService.getScore(responses);
    }
}

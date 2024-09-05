package com.mcqPortal.Controller;

import com.mcqPortal.Modal.McqModal;
import com.mcqPortal.Service.McqService;
import jakarta.persistence.GeneratedValue;
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
}

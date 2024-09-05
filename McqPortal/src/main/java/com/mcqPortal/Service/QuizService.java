package com.mcqPortal.Service;

import com.mcqPortal.Modal.McqModal;
import com.mcqPortal.Modal.QuestionWrapper;
import com.mcqPortal.Modal.Quiz;
import com.mcqPortal.Modal.Response;
import com.mcqPortal.Repository.McqRepo;
import com.mcqPortal.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    McqRepo mcqRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<McqModal> questions = mcqRepo.findRandomQuestionByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<McqModal> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (McqModal question :questionsFromDb){
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionsForUser.add(questionWrapper);
        }
        return new  ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitAnswer(int id, List<Response> response) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<McqModal> modal = quiz.get().getQuestions();

         int right=0;
         for (Response r : response){

             if (r.getResponse().equals(modal.get(i).getRightAnswer())){
                 right++;
             }
         }
        System.out.println(response);

        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}

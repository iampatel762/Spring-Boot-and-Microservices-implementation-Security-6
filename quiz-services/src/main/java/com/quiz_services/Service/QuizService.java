package com.quiz_services.Service;

import com.quiz_services.Feign.QuizInterFaceToConnectMcqModal;
import com.quiz_services.Modal.QuestionWrapper;
import com.quiz_services.Modal.Quiz;
import com.quiz_services.Modal.Response;
import com.quiz_services.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuizInterFaceToConnectMcqModal qcm;

    public ResponseEntity<String> createQuiz(String category, int numQ,String title) {
        List<Integer> questions = qcm.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepo.save(quiz);
        System.out.println(quiz);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Integer> ids = quiz.get().getQuestionIds();
        List<QuestionWrapper> questions = qcm.getQuestionFromId(ids).getBody();

        return new  ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitAnswer(int id, List<Response> responses){
        int score = qcm.getScore(responses).getBody();
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}

package com.question_services.Service;
import com.question_services.Modal.McqModal;
import com.question_services.Modal.QuestionWrapper;
import com.question_services.Modal.Response;
import com.question_services.Repository.McqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class McqService {
    @Autowired
    private McqRepo repo;

    public List<McqModal> findAllQuestions() {
        return repo.findAll();
    }

    public List<McqModal> findQuestionByCategory(String category) {
        return repo.findQuestionByCategory(category);
    }

    public void addQuestion(McqModal modal) {
        repo.save(modal);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
        List<Integer> questions = repo.findRandomQuestionByCategory(categoryName,numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionsId) {
        List<QuestionWrapper> qWrapper = new ArrayList<>();
        List<McqModal> questions = new ArrayList<>();

        for (int id:questionsId){
            questions.add(repo.findById(id).get());
        }
        for (McqModal q:questions){
            QuestionWrapper wrapper = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            qWrapper.add(wrapper);
        }
        return new ResponseEntity<>(qWrapper,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {


        int right=0;
        int i=0;
        for (Response r : responses){

            McqModal question = repo.findById(r.getId()).get();
            if (r.getResponse().equals(question.getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}

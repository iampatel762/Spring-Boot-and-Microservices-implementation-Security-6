package com.mcqPortal.Service;

import com.mcqPortal.Modal.McqModal;
import com.mcqPortal.Repository.McqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

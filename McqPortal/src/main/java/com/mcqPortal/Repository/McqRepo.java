package com.mcqPortal.Repository;

import com.mcqPortal.Modal.McqModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface McqRepo extends JpaRepository<McqModal,Integer> {

    List<McqModal> findQuestionByCategory(String category);

//    @Query(value = "SELECT * FROM McqModal q WHERE q.category =:category ORDER BY RAND() LIMIT:numQ",nativeQuery = true)
//    List<McqModal> findRandomQuestionByCategory(String category, int numQ);
    @Query(value = "SELECT * FROM McqModal q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
    List<McqModal> findRandomQuestionByCategory(@Param("category") String category,@Param("numQ") int numQ);


}

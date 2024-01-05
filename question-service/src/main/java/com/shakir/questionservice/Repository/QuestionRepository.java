package com.shakir.questionservice.Repository;


import com.shakir.questionservice.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    public List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :qNo",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int qNo);
}

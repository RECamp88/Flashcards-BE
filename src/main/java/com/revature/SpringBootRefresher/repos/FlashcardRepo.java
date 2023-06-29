package com.revature.SpringBootRefresher.repos;

import com.revature.SpringBootRefresher.models.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepo extends JpaRepository<Flashcard, Integer> {

    // TODO: add a find by Category method
    Flashcard findByCategory(Flashcard.Category category);
}

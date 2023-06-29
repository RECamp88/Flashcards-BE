package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashcardService {
    private final FlashcardRepo flashcardRepo;

    @Autowired
    public FlashcardService(FlashcardRepo flashcardRepo) {
        this.flashcardRepo = flashcardRepo;
    }

    // Create a flashcard
    // this will add a new record to the Flashcard table
    public Flashcard createFlashcard(Flashcard flashcard){
        return flashcardRepo.save(flashcard);
    }

    // Get all flashcards
    // this will retrieve a list of all the records in the flashcard table
    public List<Flashcard> getAllFlashcards(){
        return flashcardRepo.findAll();
    }

    public Flashcard findById(int id){
        return flashcardRepo.findById(id).get();
    }

    public Flashcard findByCategory(Flashcard.Category category){
        return flashcardRepo.findByCategory(category);
    }

}

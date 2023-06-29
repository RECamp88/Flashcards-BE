package com.revature.SpringBootRefresher.controllers;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("flashcards")
@CrossOrigin(origins = "*")
public class FlashcardController {
    private FlashcardService flashcardService;

    @Autowired
    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping("/all")
    public List<Flashcard> getAllFlashcards(){
        return flashcardService.getAllFlashcards();
    }

    @PostMapping
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard){
        return flashcardService.createFlashcard(flashcard);
    }

    @GetMapping("/{card_id}")
    public Flashcard getById(@PathVariable int id){
        return flashcardService.findById(id);
    }

    @GetMapping
    public Flashcard findByCategory(@RequestParam Flashcard.Category category){
        return flashcardService.findByCategory(category);
    }




}

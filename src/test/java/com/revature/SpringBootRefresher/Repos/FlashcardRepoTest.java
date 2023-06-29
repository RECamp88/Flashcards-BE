package com.revature.SpringBootRefresher.Repos;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardRepoTest {
    @Autowired
    public FlashcardRepo fr;

    @BeforeAll
    void setUpTestData(){
        Flashcard card = new Flashcard(0, "What is Spring MVC?", "An integrated version of the of the Spring Framewort and Model View Controller", Flashcard.Category.SPRING);
        card = fr.save(card);
    }
    @Test
    void createFlashcard(){
        Flashcard card = new Flashcard(0, "What of the 4 pillars of OOP", "They are Encapsulation, Inheritance, Abstraction, and Polymorphism", Flashcard.Category.JAVA);
        card = fr.save(card);

        Assertions.assertNotEquals(0,card.getId());
    }

    @Test
    void getAllFlashcards(){
        List<Flashcard> cards = fr.findAll();
        System.out.println(cards);
        Assertions.assertFalse(cards.isEmpty());
    }
}

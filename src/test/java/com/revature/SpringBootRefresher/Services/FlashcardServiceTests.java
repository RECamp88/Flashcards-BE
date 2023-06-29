package com.revature.SpringBootRefresher.Services;

import com.revature.SpringBootRefresher.models.Flashcard;
import com.revature.SpringBootRefresher.repos.FlashcardRepo;
import com.revature.SpringBootRefresher.services.FlashcardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardServiceTests {
    @Autowired
    FlashcardService fs;

    @MockBean
    FlashcardRepo fr;

    @BeforeAll
    void setUpData(){
        Flashcard card = new Flashcard(0, "What is Spring MVC?", "An integrated version of the of the Spring Framewort and Model View Controller", Flashcard.Category.SPRING);
        card = fr.save(card);
    }

    @Test
    public void createFlashcard(){
        Flashcard card = new Flashcard(0, "What of the 4 pillars of OOP", "They are Encapsulation, Inheritance, Abstraction, and Polymorphism", Flashcard.Category.JAVA);

        Mockito.when(fr.save(card)).thenReturn(new Flashcard(1, card.getQuestion(), card.getAnswer(), card.getCategory()));

        card = fs.createFlashcard(card);

        Assertions.assertNotEquals(0, card.getId());
        Assertions.assertEquals("What is Spring MVC?", card.getQuestion());
    }

    @Test
    public void viewAllFlashcards(){
        List<Flashcard> cards = new ArrayList<>();
        Flashcard card = new Flashcard(1, "What of the 4 pillars of OOP", "They are Encapsulation, Inheritance, Abstraction, and Polymorphism", Flashcard.Category.JAVA);
        cards.add(card);
        Mockito.when(fr.findAll()).thenReturn(cards);
        cards = fs.getAllFlashcards();
        Assertions.assertNotEquals(0, cards.size());
        Assertions.assertEquals(1, cards.get(0).getId());
    }
}

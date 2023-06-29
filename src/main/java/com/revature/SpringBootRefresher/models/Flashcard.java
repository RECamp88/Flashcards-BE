package com.revature.SpringBootRefresher.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String question;
    @Column(nullable = false)
    private String answer;
    @Enumerated
    private Category category;

    public enum Category{
        JAVA, SPRING, WEB, ANGULAR
    }
}

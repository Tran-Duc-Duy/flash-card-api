package com.example.flashcardbackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String front;
    private String back;
}

package com.example.flashcardbackend.sevices;

import com.example.flashcardbackend.model.Card;

import java.util.List;

public interface CardService {
    Card createCard(Card card);
    List<Card> getAllCards();

    boolean deleteCard(Long id);
}

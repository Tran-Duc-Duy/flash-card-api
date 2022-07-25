package com.example.flashcardbackend.controller;

import com.example.flashcardbackend.model.Card;
import com.example.flashcardbackend.sevices.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @PostMapping("/cards")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }
    @GetMapping("/cards")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }
}

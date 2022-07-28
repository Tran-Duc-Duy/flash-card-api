package com.example.flashcardbackend.controller;

import com.example.flashcardbackend.model.Card;
import com.example.flashcardbackend.sevices.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCard(@PathVariable(value = "id") Long id) {
        boolean deleted = false;
        deleted = cardService.deleteCard(id);
        Map<String, Boolean> response = Map.of("deleted", deleted);
        return ResponseEntity.ok(response);
    }
}

package com.example.flashcardbackend.sevices;

import com.example.flashcardbackend.entity.CardEntity;
import com.example.flashcardbackend.model.Card;
import com.example.flashcardbackend.repository.CardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card createCard(Card card) {
        CardEntity cardEntity = new CardEntity();
        BeanUtils.copyProperties(card, cardEntity);
        cardRepository.save(cardEntity);
        return card;
    }
    @Override
    public List<Card> getAllCards() {
        List<CardEntity> cardEntities = cardRepository.findAll();
        List<Card> cards= cardEntities.stream().map(card-> new Card (card.getId(),card.getFront(),card.getBack())).collect(Collectors.toList());
        return cards;
    }
}

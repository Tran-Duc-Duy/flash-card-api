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

    @Override
    public boolean deleteCard(Long id) {
        CardEntity cardEntity = cardRepository.findById(id).get();
        cardRepository.delete(cardEntity);
        return true;
    }

    @Override
    public Card getCardById(Long id) {
        CardEntity cardEntity = cardRepository.findById(id).get();
        Card card = new Card(cardEntity.getId(),cardEntity.getFront(),cardEntity.getBack());//TODO: change to constructor
        return card;
    }

    @Override
    public Card updateCard(Long id, Card card) {
        CardEntity cardEntity = cardRepository.findById(id).get();
        //BeanUtils.copyProperties(card, cardEntity);
        cardEntity.setFront(card.getFront());
        cardEntity.setBack(card.getBack());
        cardRepository.save(cardEntity);
        return card;
    }
}

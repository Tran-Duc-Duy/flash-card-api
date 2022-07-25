package com.example.flashcardbackend.repository;

import com.example.flashcardbackend.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Long> {
}

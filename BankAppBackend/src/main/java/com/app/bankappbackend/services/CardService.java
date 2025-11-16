package com.app.bankappbackend.services;

import com.app.bankappbackend.entites.Account;
import com.app.bankappbackend.entites.Card;
import com.app.bankappbackend.entites.User;
import com.app.bankappbackend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card createCard(Card newCard) {
        Random rand = new Random();
        String card = "";
        for (int i = 0; i < 17; i++)
        {
            int n = rand.nextInt(10);
            card = Integer.toString(n);
        }
        newCard.setCardNumber(card);
        return cardRepository.save(newCard);
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public void deleteCard(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        cardRepository.delete(card);
    }
}

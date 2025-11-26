package com.app.bankappbackend.controller;

import com.app.bankappbackend.entites.Account;
import com.app.bankappbackend.entites.Card;
import com.app.bankappbackend.services.CardService;
import com.app.bankappbackend.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    /**
     * CardService Injection.
     */
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping
    public Card createCard(@RequestBody Card newCard) {
        return cardService.createCard(newCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable long id) {
        Optional<Card> cardID = cardService.getCardById(id);
        return cardID.map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Card not found for ID " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}

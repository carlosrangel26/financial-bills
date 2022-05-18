package com.financial.bills.controller;

import com.financial.bills.model.Card;
import com.financial.bills.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/card")
@CrossOrigin("*")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping(value = "/all")
    public List<Card> getAllA() {
        return cardService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Card> find(@PathVariable String id) {
        Card card = cardService.get(id);
        return card != null ? new ResponseEntity<Card>(card, HttpStatus.OK) :
                new ResponseEntity<Card>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Card save(@RequestBody Card card) {
        return cardService.save(card);
    }

    @PostMapping(value = "/many")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Card> saveCards(@RequestBody List<Card> cards) {
       cards.forEach(this::save);
       return cards;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Card> delete(@PathVariable String id) {
        Card card = cardService.get(id);
        if (card != null) {
            cardService.delete(id);
            return new ResponseEntity<Card>(card, HttpStatus.OK);
        }
        return new ResponseEntity<Card>(HttpStatus.NO_CONTENT);
    }
}

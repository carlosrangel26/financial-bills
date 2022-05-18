package com.financial.bills.controller;

import com.financial.bills.model.CardBills;
import com.financial.bills.service.CardBillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/cardBills")
@CrossOrigin("*")
public class CardBillsController {

    @Autowired
    CardBillsService cardBillsService;

    @GetMapping(value = "/all")
    public List<CardBills> getAllA() {
        return cardBillsService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CardBills> find(@PathVariable String id) {
        CardBills cardBills = cardBillsService.get(id);
        return cardBills != null ? new ResponseEntity<CardBills>(cardBills, HttpStatus.OK) :
                new ResponseEntity<CardBills>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardBills save(@RequestBody CardBills cardBills) {
        return cardBillsService.save(cardBills);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CardBills> delete(@PathVariable String id) {
        CardBills cardBills = cardBillsService.get(id);
        if (cardBills != null) {
            cardBillsService.delete(id);
            return new ResponseEntity<CardBills>(cardBills, HttpStatus.OK);
        }
        return new ResponseEntity<CardBills>(HttpStatus.NO_CONTENT);
    }
}

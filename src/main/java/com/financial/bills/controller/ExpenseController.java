package com.financial.bills.controller;

import com.financial.bills.model.Expense;
import com.financial.bills.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/expense")
@CrossOrigin("*")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping(value = "/all")
    public List<Expense> getAllA() {
        return expenseService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Expense> find(@PathVariable String id) {
        Expense expense = expenseService.get(id);
        return expense != null ? new ResponseEntity<Expense>(expense, HttpStatus.OK) :
                new ResponseEntity<Expense>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expense save(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Expense> delete(@PathVariable String id) {
        Expense expense = expenseService.get(id);
        if (expense != null) {
            expenseService.delete(id);
            return new ResponseEntity<Expense>(expense, HttpStatus.OK);
        }
        return new ResponseEntity<Expense>(HttpStatus.NO_CONTENT);
    }
}

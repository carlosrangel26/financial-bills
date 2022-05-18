package com.financial.bills.controller;

import com.financial.bills.model.Account;
import com.financial.bills.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/account")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/all")
    public List<Account> getAllA() {
        return accountService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> find(@PathVariable String id) {
        Account account = accountService.get(id);
        return account != null ? new ResponseEntity<Account>(account, HttpStatus.OK) :
                new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Account> delete(@PathVariable String id) {
        Account account = accountService.get(id);
        if (account != null) {
            accountService.delete(id);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        }
        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }
}

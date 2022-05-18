package com.financial.bills.controller;

import com.financial.bills.model.Period;
import com.financial.bills.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/period")
@CrossOrigin("*")
public class PeriodController {

    @Autowired
    PeriodService periodService;

    @GetMapping(value = "/all")
    public List<Period> getAllA() {
        return periodService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Period> find(@PathVariable String id) {
        Period period = periodService.get(id);
        return period != null ? new ResponseEntity<Period>(period, HttpStatus.OK) :
                new ResponseEntity<Period>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/name")
    public ResponseEntity<List<Period>> findByName(@RequestParam(required = true) String name) {
        List<Period> periods = periodService.findByName(name);
        return periods != null ? new ResponseEntity<List<Period>>(periods, HttpStatus.OK) :
                new ResponseEntity<List<Period>>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Period> findByNameAndYear(@RequestParam(required = true) String name,
                                                             @RequestParam(required = true) int year) {
        Period period = periodService.findByNameAndYear(name, year);
        return period != null ? new ResponseEntity<Period>(period, HttpStatus.OK) :
                new ResponseEntity<Period>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Period period) {
        periodService.save(period);
    }

    @PostMapping(value = "/many")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Period> savePeriods(@RequestBody List<Period> periods) {
        periods.forEach(this::save);
        return periods;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Period> delete(@PathVariable String id) {
        Period period = periodService.get(id);
        if (period != null) {
            periodService.delete(id);
            return new ResponseEntity<Period>(period, HttpStatus.OK);
        }
        return new ResponseEntity<Period>(HttpStatus.NO_CONTENT);
    }
}
package com.financial.bills.service.impl;

import com.financial.bills.commons.GenericServiceImpl;
import com.financial.bills.dao.PeriodRepository;
import com.financial.bills.model.Period;
import com.financial.bills.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.List;

@Service
public class PeriodServiceImpl extends GenericServiceImpl<Period, String> implements PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    @Override
    public CrudRepository<Period, String> getDao() {
        return periodRepository;
    }

    @Override
    public List<Period> findByName(String name) {
        return periodRepository.findName(name);
    }

    @Override
    public Period findByNameAndYear(String name, int year) {
        return periodRepository.findByNameAndYear(name, year);
    }
}

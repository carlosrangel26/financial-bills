package com.financial.bills.service.impl;

import com.financial.bills.commons.GenericServiceImpl;
import com.financial.bills.dao.ExpenseRepository;
import com.financial.bills.model.Expense;
import com.financial.bills.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl extends GenericServiceImpl<Expense, String> implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public CrudRepository<Expense, String> getDao() {
        return expenseRepository;
    }
}

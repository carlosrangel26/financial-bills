package com.financial.bills.service.impl;

import com.financial.bills.commons.GenericServiceImpl;
import com.financial.bills.dao.CardBillsRepository;
import com.financial.bills.model.CardBills;
import com.financial.bills.service.CardBillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CardBillsServiceImpl extends GenericServiceImpl<CardBills, String> implements CardBillsService {

    @Autowired
    private CardBillsRepository accountRepository;

    @Override
    public CrudRepository<CardBills, String> getDao() {
        return accountRepository;
    }
}

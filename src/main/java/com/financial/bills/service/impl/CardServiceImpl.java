package com.financial.bills.service.impl;

import com.financial.bills.commons.GenericServiceImpl;
import com.financial.bills.dao.CardRepository;
import com.financial.bills.model.Card;
import com.financial.bills.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends GenericServiceImpl<Card, String> implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public CrudRepository<Card, String> getDao() {
        return cardRepository;
    }
}

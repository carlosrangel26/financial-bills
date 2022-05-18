package com.financial.bills.service.impl;

import com.financial.bills.commons.GenericServiceImpl;
import com.financial.bills.dao.AccountRepository;
import com.financial.bills.model.Account;
import com.financial.bills.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends GenericServiceImpl<Account, String> implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CrudRepository<Account, String> getDao() {
        return accountRepository;
    }
}

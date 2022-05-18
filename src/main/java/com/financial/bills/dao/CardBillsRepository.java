package com.financial.bills.dao;

import com.financial.bills.model.CardBills;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardBillsRepository extends MongoRepository<CardBills, String> {
}

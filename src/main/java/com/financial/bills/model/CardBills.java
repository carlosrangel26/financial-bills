package com.financial.bills.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cardBills")
public class CardBills implements Serializable {

    @Id
    private String id;
    private String store;
    private String concept;
    private int currentPayment;
    private int totalPayments;
    private int monthsLeft;
    private BigDecimal totalAmount;
    private BigDecimal monthlyAmount;
    private String amountOwed;
    private Card card;
}

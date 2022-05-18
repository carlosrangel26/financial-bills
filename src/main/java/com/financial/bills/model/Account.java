package com.financial.bills.model;

import com.financial.bills.enums.AccountType;
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
@Document(collection = "bills")
public class Account implements Serializable {

    @Id
    private String id;
    private AccountType accountType;
    private String concept;
    private String person;
    private BigDecimal amount;
    private BigDecimal paidOut;
    private int paymentNumber;
    private int totalPayments;
    private String note;
    private Period period;
}

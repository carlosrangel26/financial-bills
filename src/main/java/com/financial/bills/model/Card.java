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
@Document(collection = "cards")
public class Card implements Serializable {

    @Id
    private String id;
    private String name;
    private String bankName;
    private int CuttingDay;
    private BigDecimal totalDebt;
}

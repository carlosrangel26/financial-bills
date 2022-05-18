package com.financial.bills.model;

import com.financial.bills.enums.NamePeriod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "period")
public class Period implements Serializable {

    @Id
    private String id;
    private NamePeriod name;
    private int year;
}

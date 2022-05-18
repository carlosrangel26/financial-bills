package com.financial.bills.service;

import com.financial.bills.commons.GenericService;
import com.financial.bills.model.Period;

import java.util.List;

public interface PeriodService extends GenericService<Period, String> {
    List<Period> findByName(String name);
    Period findByNameAndYear(String name, int year);
}

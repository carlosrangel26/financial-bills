package com.financial.bills.dao;

import com.financial.bills.model.Period;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PeriodRepository extends MongoRepository<Period, String> {
//    @Query(value = "{ 'name' : ?0 }", fields = "{ 'name': 1 }")
@Query("{ 'name' : ?0 }")
    List<Period> findName(String name);
    @Query("{ 'name' : ?0, 'year' : ?1}")
    Period findByNameAndYear(String name, int year);
}
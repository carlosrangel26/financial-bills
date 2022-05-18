package com.financial.bills.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements  GenericService<T, ID> {

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        return getDao().findById(id).orElse(null);
    }

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        getDao().findAll().forEach(returnList::add);
        return returnList;
    }

    public abstract CrudRepository<T, ID> getDao();

}

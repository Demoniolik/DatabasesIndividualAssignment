package com.individual.assignment.bekker.assignment.dao;

import java.util.List;

public interface DAO <T> {
    T get(long id);
    List<T> getAll();
    T save(T t);
    void update(T t, String[] params);
    void delete(T t);
}

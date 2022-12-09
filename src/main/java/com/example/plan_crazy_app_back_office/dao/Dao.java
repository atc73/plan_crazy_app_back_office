package com.example.plan_crazy_app_back_office.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();

    Optional<T> findById(Long id);

    void save(T t);

    void update(T t);

    void delete(T t);
}

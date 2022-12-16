package com.example.plan_crazy_app_back_office.dao;

import com.example.plan_crazy_app_back_office.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    void create(T t);

    Optional<AppUser> findByEmail(String email);

    void update(T t);

    void delete(Long t);
}

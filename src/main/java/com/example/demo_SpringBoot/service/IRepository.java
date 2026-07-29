package com.example.demo_SpringBoot.service;

import java.util.List;

public interface IRepository<T, F> {
    F findById(T id);

    List<F> findAll();

    F save(F entity);
}

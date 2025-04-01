package com.pizza_shop.repository;

import com.pizza_shop.model.Pizza;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends ReactiveMongoRepository<Pizza, String> {
}
package com.pizza_shop.controller;

import com.pizza_shop.model.Pizza;
import com.pizza_shop.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/")
    public Flux<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Pizza> getPizzaById(@PathVariable String id) {
        return pizzaRepository.findById(id);
    }

    @PostMapping
    public Mono<Pizza> addPizza(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @PutMapping("/{id}")
    public Mono<Pizza> updatePizza(@PathVariable String id, @RequestBody Pizza pizzaDetails) {
        return pizzaRepository.findById(id)
                .flatMap(pizza -> {
                    pizza.setName(pizzaDetails.getName());
                    pizza.setPrice(pizzaDetails.getPrice());
                    return pizzaRepository.save(pizza);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePizza(@PathVariable String id) {
        return pizzaRepository.deleteById(id);
    }
}
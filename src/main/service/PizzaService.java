package com.pizzashop.service;

import com.pizzashop.model.Pizza;
import com.pizzashop.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizzaById(String id) {
        return pizzaRepository.findById(id);
    }

    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(String id, Pizza pizza) {
        if (pizzaRepository.existsById(id)) {
            pizza.setId(id);
            return pizzaRepository.save(pizza);
        }
        return null;
    }

    public void deletePizza(String id) {
        pizzaRepository.deleteById(id);
    }
}
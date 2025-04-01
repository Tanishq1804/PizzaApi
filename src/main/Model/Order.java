package com.pizzashop.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private List<Pizza> pizzas;
    private String status; // "Preparing", "Delivered", etc.
    private LocalDateTime timestamp;

    // Constructors
    public Order() {}

    public Order(List<Pizza> pizzas, String status) {
        this.pizzas = pizzas;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<Pizza> getPizzas() { return pizzas; }
    public void setPizzas(List<Pizza> pizzas) { this.pizzas = pizzas; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
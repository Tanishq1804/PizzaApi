package com.pizzashop.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pizzas")
public class Pizza {
    @Id
    private String id;
    private String name;
    private String size;
    private double price;
}
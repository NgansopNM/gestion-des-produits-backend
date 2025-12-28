package com.martialdev.API_produit.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private Integer quantity;

    // ✅ CONSTRUCTEUR SANS ARGUMENT (OBLIGATOIRE POUR JPA)
    public Product() {
    }

    // ✅ CONSTRUCTEUR AVEC ARGUMENTS (OPTIONNEL MAIS UTILE)
    public Product(Long id, String name, String description, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // ✅ GETTERS & SETTERS EXPLICITES

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {            // ✅ setName existe
        return name;
    }

    public void setName(String name) {   // ✅ PROBLÈME RÉSOLU ICI
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

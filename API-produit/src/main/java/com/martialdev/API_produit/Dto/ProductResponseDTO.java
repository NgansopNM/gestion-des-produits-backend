package com.martialdev.API_produit.Dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer quantity
) {}

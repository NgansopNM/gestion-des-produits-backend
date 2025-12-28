package com.martialdev.API_produit.Dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequestDTO(

        @NotBlank(message = "Le nom est obligatoire")
        String name,

        String description,

        @NotNull @Positive(message = "Le prix doit être positif")
        BigDecimal price,

        @PositiveOrZero
        Integer quantity
) {

}

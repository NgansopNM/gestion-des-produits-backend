package com.martialdev.API_produit.Mapper;

import com.martialdev.API_produit.Dto.ProductRequestDTO;
import com.martialdev.API_produit.Dto.ProductResponseDTO;
import com.martialdev.API_produit.Entity.Product;

public class ProductMapper {

    // Conversion DTO → Entity
    public static Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();          // constructeur vide
        product.setName(dto.name());              // setters existants
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setQuantity(dto.quantity());
        return product;
    }

    // Conversion Entity → DTO
    public static ProductResponseDTO toDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}

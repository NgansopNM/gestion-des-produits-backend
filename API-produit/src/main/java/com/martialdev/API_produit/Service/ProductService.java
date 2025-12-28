package com.martialdev.API_produit.Service;



import com.martialdev.API_produit.Dto.ProductRequestDTO;
import com.martialdev.API_produit.Dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO create(ProductRequestDTO dto);

    List<ProductResponseDTO> findAll();

    ProductResponseDTO findById(Long id);

    ProductResponseDTO update(Long id, ProductRequestDTO dto);

    void delete(Long id);
}

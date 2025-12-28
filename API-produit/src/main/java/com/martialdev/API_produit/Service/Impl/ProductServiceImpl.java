package com.martialdev.API_produit.Service.Impl;


import com.martialdev.API_produit.Dto.ProductRequestDTO;
import com.martialdev.API_produit.Dto.ProductResponseDTO;
import com.martialdev.API_produit.Entity.Product;
import com.martialdev.API_produit.Exception.ResourceNotFoundException;
import com.martialdev.API_produit.Mapper.ProductMapper;
import com.martialdev.API_produit.Repository.ProductRepository;
import com.martialdev.API_produit.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductResponseDTO create(ProductRequestDTO dto) {
        Product product = ProductMapper.toEntity(dto);
        return ProductMapper.toDTO(repository.save(product));
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Produit avec ID " + id + " introuvable"));
        return ProductMapper.toDTO(product);
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Produit avec ID " + id + " introuvable"));

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setQuantity(dto.quantity());

        return ProductMapper.toDTO(repository.save(product));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produit avec ID " + id + " introuvable");
        }
        repository.deleteById(id);
    }
}

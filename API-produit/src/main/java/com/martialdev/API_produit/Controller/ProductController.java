package com.martialdev.API_produit.Controller;


import com.martialdev.API_produit.Dto.ProductRequestDTO;
import com.martialdev.API_produit.Dto.ProductResponseDTO;
import com.martialdev.API_produit.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = {"http://localhost:5173", "https://ton-frontend.vercel.app"}) // React
public class ProductController {

    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponseDTO create(@Valid @RequestBody ProductRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

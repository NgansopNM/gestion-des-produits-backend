package com.martialdev.API_produit.Repository;



import com.martialdev.API_produit.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

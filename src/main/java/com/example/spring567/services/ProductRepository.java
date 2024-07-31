package com.example.spring567.services;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring567.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

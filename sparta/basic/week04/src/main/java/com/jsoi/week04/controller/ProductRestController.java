package com.jsoi.week04.controller;

import com.jsoi.week04.domain.Product;
import com.jsoi.week04.domain.ProductMypriceRequestDto;
import com.jsoi.week04.domain.ProductRepository;
import com.jsoi.week04.domain.ProductRequestDto;
import com.jsoi.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    private final ProductRepository productRepository;


    @GetMapping("/api/products")
    public List<Product> showProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productRepository.save(new Product(productRequestDto));
    }
}

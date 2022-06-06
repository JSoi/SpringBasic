package com.sparta.springcore.service;

import com.sparta.springcore.dto.ProductMyPriceRequestDto;
import com.sparta.springcore.dto.ProductRequestDto;
import com.sparta.springcore.model.Product;
import com.sparta.springcore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequestDto productRequestDto) {
        return productRepository.save(new Product(productRequestDto));
    }

    public Product updateProduct(Long id, ProductMyPriceRequestDto productMyPriceRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다"));
        product.setMyprice(productMyPriceRequestDto.getMyprice());
        productRepository.save(product);
        // 응답 보내기 (업데이트된 상품 id)
        return product;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}

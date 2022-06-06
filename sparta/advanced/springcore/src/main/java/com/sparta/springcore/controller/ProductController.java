package com.sparta.springcore.controller;

import com.sparta.springcore.dto.ProductMyPriceRequestDto;
import com.sparta.springcore.dto.ProductRequestDto;
import com.sparta.springcore.service.ProductService;
import com.sparta.springcore.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {
    private final ProductService productService;

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
// 요청받은 DTO 로 DB에 저장할 객체 만들기
        return productService.createProduct(requestDto);

    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductMyPriceRequestDto requestDto) throws SQLException {
        return productService.updateProduct(id, requestDto);
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() throws SQLException {
        return productService.getProducts();
    }
}

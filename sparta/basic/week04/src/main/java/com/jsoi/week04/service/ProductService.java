package com.jsoi.week04.service;

import com.jsoi.week04.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto productMypriceRequestDto) {
        Product oldProduct = productRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 아이디의 상품을 찾을 수 없습니다"));
        oldProduct.update(productMypriceRequestDto);
        return id;
    }

    @Transactional //DB 업데이트가 필요하다
    public void updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다"));
        product.updateByItemDto(itemDto);
    }
}

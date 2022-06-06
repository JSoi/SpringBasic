package com.jsoi.week04.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private int lprice;
    @Column(nullable = false)
    private int myprice;

    // 관심상품 생성
    public Product(ProductRequestDto productRequestDto) {
        this.link = productRequestDto.getLink();
        this.title = productRequestDto.getTitle();
        this.lprice = productRequestDto.getLprice();
        this.myprice = 0;
        this.image = productRequestDto.getImage();
    }

    // 가격 변화시
    public void update(ProductMypriceRequestDto productMypriceRequestDto) {
        this.myprice = productMypriceRequestDto.getMyprice();
    }

    public void updateByItemDto(ItemDto itemDto) {
        this.lprice = itemDto.getLprice();
    }
}

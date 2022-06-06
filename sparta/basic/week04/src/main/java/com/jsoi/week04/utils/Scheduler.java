package com.jsoi.week04.utils;

import com.jsoi.week04.domain.ItemDto;
import com.jsoi.week04.domain.Product;
import com.jsoi.week04.domain.ProductRepository;
import com.jsoi.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class Scheduler {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final NaverShopSearch naverShopSearch;

    @Scheduled(cron = "0 0 1 * * *")
    public void updatePrice() throws InterruptedException {
        System.out.println("Scheduler.updatePrice");
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            TimeUnit.SECONDS.sleep(1);
            String title = product.getTitle();
            String resultString = naverShopSearch.search(title);
            List<ItemDto> itemDtos = naverShopSearch.fromJsontoItems(resultString);
            Long id = product.getId();
            productService.updateBySearch(id, itemDtos.get(0));
        }

    }
}

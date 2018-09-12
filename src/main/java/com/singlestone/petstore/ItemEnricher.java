package com.singlestone.petstore;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/*
 * retrieves data from rest api to populate name and price
 */

@Service
public class ItemEnricher {
    private HashMap<String,ItemDetail> detailCache;
    private final RestTemplate restTemplate;

    public ItemEnricher(RestTemplateBuilder restTemplateBuilder) {
        this.detailCache = new HashMap<>();
        this.restTemplate = restTemplateBuilder.build();
    }

    public ItemDetail getItemDetail(String productId){
        if(detailCache.containsKey(productId))
            return detailCache.get(productId);
        else{
           String url = "https://petstoreapp.azurewebsites.net/api/products/{productId}"; //String.format(" https://petstoreapp.azurewebsites.net/api/products/%s",productId);
            ItemDetail itemDetail = this.restTemplate
                    .getForObject(url,ItemDetail.class,productId);
            detailCache.put(productId, itemDetail);
            return itemDetail;
        }
    }
}

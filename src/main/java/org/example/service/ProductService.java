package org.example.service;

import org.example.model.Item;
import org.example.model.ProductOfferInventory;
import org.example.model.Stock;

public class ProductService {
    public static Item getItem(String name, ProductOfferInventory productOfferInventory) {
        for(Stock stock : productOfferInventory.getStocks()) {
            if(stock.getItem().getName().equals(name)) {
                return stock.getItem();
            }
        }
        return null;
    }
}

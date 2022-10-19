package org.example.service;

import org.example.model.ProductOfferInventory;
import org.example.model.Stock;

public class InventoryService {
    public static String getProductNames(ProductOfferInventory productOfferInventory) {
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for (Stock stock : productOfferInventory.getStocks()) {
            if (isFirst) {
                sb.append(stock.getItem().getName());
                isFirst = false;
            } else {
                sb.append(", ");
                sb.append(stock.getItem().getName());
            }
        }
        return sb.toString();
    }
}

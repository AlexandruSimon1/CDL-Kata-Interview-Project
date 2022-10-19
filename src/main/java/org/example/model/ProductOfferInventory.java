package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ProductOfferInventory {

    List<Stock> stocks = new ArrayList<>();
    List<SpecialOffer> specialOffers = new ArrayList<>();

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Stock stock) {
        stocks.add(stock);
    }

    public List<SpecialOffer> getOffers() {
        return specialOffers;
    }

    public void setOffers(SpecialOffer specialOffer) {
        this.specialOffers.add(specialOffer);
    }
}

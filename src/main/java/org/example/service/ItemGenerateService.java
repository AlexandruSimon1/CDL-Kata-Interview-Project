package org.example.service;

import org.example.model.*;

public class ItemGenerateService {
    public static ProductOfferInventory generateInitialItems() {
        ProductOfferInventory productOfferInventory = new ProductOfferInventory();
        Category category1 = new Category("C1", "Category1");
        Category category2 = new Category("C2", "Category2");
        Category category3 = new Category("C3", "Category3");
        Category category4 = new Category("C4", "Category4");

        Item item1 = new Item("A", 50, category1);
        Item item2 = new Item("B", 30, category2);
        Item item3 = new Item("C", 20, category3);
        Item item4 = new Item("D", 15, category4);

        productOfferInventory.setStocks(new Stock(item1, 200));
        productOfferInventory.setStocks(new Stock(item2, 400));
        productOfferInventory.setStocks(new Stock(item3, 500));
        productOfferInventory.setStocks(new Stock(item4, 700));
        SpecialOffer specialOffer1 = new SpecialOffer("SpecialOffer1", 3, 130);
        SpecialOffer specialOffer2 = new SpecialOffer("SpecialOffer2", 2, 45);
        specialOffer1.setCategories(category1);
        specialOffer2.setCategories(category2);
        productOfferInventory.setOffers(specialOffer1);
        productOfferInventory.setOffers(specialOffer2);
        return productOfferInventory;
    }
}

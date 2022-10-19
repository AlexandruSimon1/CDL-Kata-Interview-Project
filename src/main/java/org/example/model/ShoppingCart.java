package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> itemMap = new HashMap<>();
    private Map<SpecialOffer, Integer> specialOfferMap = new HashMap<>();

    public Map<Item, Integer> getItemMap() {
        return itemMap;
    }

    public Integer getItemCount(Item item) {
        return itemMap.get(item);
    }

    public void setItemMap(Item item, Integer count) {
        removeItem(item);
        itemMap.put(item, count);
    }

    public void removeItem(Item item) {
        if (itemMap.containsKey(item)) {
            itemMap.remove(item);
        }
    }

    public void setItemMap(Map<Item, Integer> itemMap) {
        this.itemMap = itemMap;
    }

    public Map<SpecialOffer, Integer> getSpecialOfferMap() {
        return specialOfferMap;
    }

    public Integer getSpecialOfferCount(SpecialOffer specialOffer) {
        return specialOfferMap.get(specialOffer);
    }

    public void addSpecialOfferCount(SpecialOffer specialOffer, Integer count) {
        if (specialOfferMap.containsKey(specialOffer)) {
            specialOfferMap.remove(specialOffer);
        }
        specialOfferMap.put(specialOffer, count);
    }

    public void setSpecialOfferMap(Map<SpecialOffer, Integer> specialOfferMap) {
        this.specialOfferMap = specialOfferMap;
    }
}

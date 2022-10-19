package org.example.service;

import org.example.model.*;
import java.util.Map.Entry;

public class ShoppingCartService {
    public static ShoppingCart calculateNewShoppingCard(Item item, ShoppingCart shoppingCart,
                                                  ProductOfferInventory productOfferInventory) {
        ShoppingCart returnCart = shoppingCart;
        Integer itemCount = getItemCount(item, returnCart);
        SpecialOffer offer = getSpecialOfferItem(item, productOfferInventory);
        if (offer == null) {
            returnCart.setItemMap(item, itemCount);
        } else if (itemCount == offer.getGroupNumber()) {
            addSpecialOfferIntoShoppingCart(item, returnCart, offer);
        } else {
            returnCart.setItemMap(item, itemCount);
        }
        return returnCart;
    }

    public static float getShoppingCartTotal(ShoppingCart shoppingCart) {
        float returnValue = 0;
        for(Entry<Item, Integer> productItems:shoppingCart.getItemMap().entrySet()) {
            returnValue += productItems.getKey().getPrice() * productItems.getValue();
        }
        for(Entry<SpecialOffer, Integer> specialOffers:shoppingCart.getSpecialOfferMap().entrySet()) {
            returnValue += specialOffers.getKey().getSpecialPrice() * specialOffers.getValue();
        }
        return returnValue;
    }

    private static Integer getItemCount(Item newItem, ShoppingCart returnBasket) {
        Integer itemCount = returnBasket.getItemCount(newItem);
        if (itemCount == null) {
            itemCount = 0;
        }
        itemCount = itemCount + 1;
        return itemCount;
    }

    private static void addSpecialOfferIntoShoppingCart(Item item, ShoppingCart shoppingCart, SpecialOffer specialOffer) {
        shoppingCart.removeItem(item);
        Integer specialOfferCount = shoppingCart.getSpecialOfferCount(specialOffer);
        if (specialOfferCount == null) {
            specialOfferCount = 0;
        }
        specialOfferCount = specialOfferCount + 1;
        specialOffer.setItems(item);
        shoppingCart.addSpecialOfferCount(specialOffer, specialOfferCount);
    }

    private static SpecialOffer getSpecialOfferItem(Item item, ProductOfferInventory productOfferInventory) {
        for (SpecialOffer specialOffer : productOfferInventory.getOffers()) {
            boolean hasMatchingCatagory = false;
            for (Category category : specialOffer.getCategories()) {
                if (category != null && category.getName().equals(item.getCategory().getName())) {
                    hasMatchingCatagory = true;
                    break;
                }
            }
            if (hasMatchingCatagory) {
                return specialOffer;
            }
        }
        return null;
    }
}

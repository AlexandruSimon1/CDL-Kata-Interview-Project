package org.example;

import org.example.model.Item;
import org.example.model.ProductOfferInventory;
import org.example.model.ShoppingCart;
import org.example.service.InventoryService;
import org.example.service.ItemGenerateService;
import org.example.service.ProductService;
import org.example.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.Scanner;

public class CDLKata {
    private static final String FINALIZE_STRING = "FINALIZE";

    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            ProductOfferInventory productOfferInventory = ItemGenerateService.generateInitialItems();
            System.out.println("Please enter item that you want to buy.");
            ShoppingCart shoppingCart = new ShoppingCart();
            ArrayList<Item> items = new ArrayList<>();
            String inputProduct = null;
            while (!FINALIZE_STRING.equals(inputProduct)) {
                System.out.println("Your item from " + InventoryService.getProductNames(productOfferInventory) + ". For checkout type: " + FINALIZE_STRING);
                inputProduct = inputScanner.nextLine().toUpperCase();
                Item item = ProductService.getItem(inputProduct, productOfferInventory);
                if (item == null) {
                    System.out.println("Please enter valid item");
                    System.out.println("All Valid items are: " + InventoryService.getProductNames(productOfferInventory));
                } else if (!FINALIZE_STRING.equals(inputProduct)) {
                    items.add(item);
                    shoppingCart = ShoppingCartService.calculateNewShoppingCard(item, shoppingCart, productOfferInventory);
                }
            }
            System.out.println("Bought items " + items);
            System.out.println("Your item total is : " + ShoppingCartService.getShoppingCartTotal(shoppingCart));
        }
    }
}
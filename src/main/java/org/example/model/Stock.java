package org.example.model;

public class Stock {
    private Item item;
    private int inStockNumber;

    public Stock(Item item, int inStockNumber) {
        this.item = item;
        this.inStockNumber = inStockNumber;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public int getInStockNumber() {
        return inStockNumber;
    }
    public void setInStockNumber(int inStockNumber) {
        this.inStockNumber = inStockNumber;
    }
}

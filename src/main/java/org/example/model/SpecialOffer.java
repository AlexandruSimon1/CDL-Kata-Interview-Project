package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpecialOffer {
    private String name;
    private List<Category> categories = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private int groupNumber;
    private float specialPrice;

    private LocalDate offerStartDate = LocalDate.now();
    private LocalDate offerEndDate = LocalDate.now().plusDays(1);

    public SpecialOffer(String name, int groupNumber, float specialPrice) {
        this.name = name;
        this.groupNumber = groupNumber;
        this.specialPrice = specialPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(Category category) {
        categories.add(category);
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public float getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(float specialPrice) {
        this.specialPrice = specialPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(Item item) {
        items.add(item);
    }

    public LocalDate getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(LocalDate offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    public LocalDate getOfferEndDate() {
        return offerEndDate;
    }

    public void setOfferEndDate(LocalDate offerEndDate) {
        this.offerEndDate = offerEndDate;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        SpecialOffer specialOffer = (SpecialOffer) obj;
        if (specialOffer.getName().equals(name)) {
            return true;
        } else {
            return false;
        }
    }
}

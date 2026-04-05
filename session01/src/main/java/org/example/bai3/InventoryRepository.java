package org.example.bai3;

public interface InventoryRepository {
    int getFoodQuantity(String foodName);
    double getFoodPrice(String foodName);
    void reduceFood(String foodName, int quantity);
}
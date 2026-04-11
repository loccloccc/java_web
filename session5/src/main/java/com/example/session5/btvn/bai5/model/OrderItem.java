package com.example.session5.btvn.bai5.model;

public class OrderItem {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public OrderItem() {}

    public OrderItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    // getter/setter
}

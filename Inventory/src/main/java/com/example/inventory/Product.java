package com.example.inventory;

import java.text.NumberFormat;

public class Product {
    private String item;
    private double price;
    private int quantity;
    public Product(String i, double p, int q){
        item = i;
        price = p;
        quantity = q;
    }
    public String getItem() {
        return item;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public String toString(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return item + " - " + formatter.format(price) + " - " + quantity;
    }
}

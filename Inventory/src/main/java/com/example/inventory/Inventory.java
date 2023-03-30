package com.example.inventory;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;
    private int max;
    public Inventory(){
        products = new ArrayList<Product>();
    }
    public void addNewProduct(String name, double cost, int amount){
        Product product = new Product(name, cost, amount);
        products.add(product);
        sort(products);
    }
    public ArrayList<String> mustOrder(){
        ArrayList<String> output = new ArrayList<String>();
        for (Product product : products){
            if(product.getQuantity() < 20){
                output.add(product.getItem());
            }
        }
        return output;
    }
    public ArrayList<Product> displayProducts(){
        return products;
    }
    public static void sort(ArrayList<Product> list){
        list.sort((o1, o2) -> o1.getItem().compareTo(o2.getItem()));
    }

}

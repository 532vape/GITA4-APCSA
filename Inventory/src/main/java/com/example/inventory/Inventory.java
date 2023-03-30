package com.example.inventory;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<qualityControl> products;
    private int max;
    public Inventory(){
        products = new ArrayList<qualityControl>();
    }
    public void addNewProduct(String name, double cost, int amount, int satisfaction, int quality){
        qualityControl product = new qualityControl(name, cost, amount, satisfaction, quality);
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
    public ArrayList<qualityControl> displayProducts(){
        return products;
    }
    public static void sort(ArrayList<qualityControl> list){
        list.sort((o1, o2) -> o1.getItem().compareTo(o2.getItem()));
    }

    public ArrayList<String> poorReviews(){
        ArrayList<String> output = new ArrayList<String>();
        for (qualityControl item : products){
            if(item.getSatis() < 5 || item.getQual() < 5){
                output.add(item.getItem()); //naming is all ducked up
            }
        }
        return output;
    }

}

package com.example.inventory;

import java.text.NumberFormat;

public class qualityControl extends Product{
    private int satisfaction;
    private int quality;
    qualityControl(String name, double cost, int quantity, int intSatisfaction, int intQuality){
        super(name, cost, quantity);
        satisfaction = intSatisfaction;
        quality = intQuality;
    }

    public int getSatis(){
        return satisfaction;
    }

    public int getQual(){
        return quality;
    }

    public String toString(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return getItem() + " | " + formatter.format(getPrice()) + " | " + getQuantity() + "x" + " | " + getSatis() + "/10" + " | " + getQual() + "/10";
    }
}

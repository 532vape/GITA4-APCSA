package com.example.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
    Inventory inventory = new Inventory();
    @FXML
    private Button btnAdd;
    @FXML
    private TextArea output;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtCost;
    @FXML
    private TextField txtQuantity;
    @FXML
    private Button btnDisplay;
    @FXML
    private Button mustOrder;

    public void onBtnAddClick(){
        inventory.addNewProduct(txtName.getText(), Double.parseDouble(txtCost.getText()),
                Integer.parseInt(txtQuantity.getText()));
//        System.out.println("this works");

    }
    public void onBtnOrderClick(){
        output.setText(String.valueOf(inventory.mustOrder()));
    }
    public void onBtnDisplayClick(){
        output.setText(String.valueOf(inventory.displayProducts()));
    }
}
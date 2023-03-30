/*
 * David Lim
 * 9/2/22
 * Dice Roll
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main extends JFrame implements ActionListener{
    int rollMin = 1;
    int rollMax = 6;

    int randomRoll1; //don't assign value here so it can change with every button click
    int randomRoll2;
    JTextArea txaRandomRoll = new JTextArea("", 10, 30);
    JButton btnRoll = new JButton("Roll");

    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);
        frame.setVisible(true);

    }

    //declare constructor for the project
    public Main(){
        //application bar name
        super("Dice Roll");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //layout manager
        setLayout(new FlowLayout());

        //screen components
        add(txaRandomRoll);
        add(btnRoll);

        //add listener for the button
        btnRoll.addActionListener(this);
    }//end of constructor

    //execute code below on button click

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        
        if (objSource == btnRoll){
            txaRandomRoll.setText("");
            randomRoll1 = (int)Math.floor(Math.random() *  (rollMax - rollMin + 1) + rollMin);
            randomRoll2 = (int)Math.floor(Math.random() *  (rollMax - rollMin + 1) + rollMin);

            //initialize class for calculation
            calculate calculate = new calculate(randomRoll1, randomRoll2);

            //get values for calculate class
            int sum = calculate.getSum();

            String outputString = "";

            //output
            outputString = "Roll 1: " + randomRoll1 + "\t" + "Roll 2: " + randomRoll2 + "\n"
            + "Roll sum: " + sum + "\t" + "Sum Counts: " + Arrays.toString(calculate.returnRollCount()) + "\n" +
            "Roll Probabilities: " + Arrays.toString(calculate.returnArray()) + "\n" + "Total Rolls: " + calculate.getRolls();
            txaRandomRoll.append(outputString);
        }
        
    }

}



//Name: Mister S
//Date: 10/29/18
/*
 * This project codes a timer
 * and animation
 */

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import java.awt.event.*;
import java.util.ArrayList;


public class Main extends JFrame implements ActionListener{



    //timer buttons
    JButton btnStart = new JButton("Run");
    JTextField input = new JTextField(5);
    JTextArea output = new JTextArea(5,10);
    //Location variables for circle


    public Main(){


        super("Button Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //pnlInput.setLayout(new GridLayout(0,2));
        add(btnStart);
        add(input);
        add(output);
        btnStart.addActionListener(this);

    }
    public static void main(String[]args){

        //Place components on the applet panel
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 500;

        Main frame = new Main();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);


    }
    //when you push the button it comes this method
    public void actionPerformed(ActionEvent event){

        //declare variable to hold which button is called
        Object source = event.getSource();

        if (source == btnStart)
        {
            int num = Integer.parseInt(input.getText());
            System.out.printf("Dividing %s by 3%n", num);
            divide(num);
            System.out.printf("%s odd numbers", num);
            odd(num, 0);
            System.out.println("GCF of 36 and 38");
            gcf(36, 48);
//            System.out.println("Ah");
        }
        //requestFocus();
    }

    public void divide(int num)
    {
        int result = num / 3;
        System.out.println(result);
        if (result <= 1) return;
        divide(result);
    }

    public void odd(int num, int counter)
    {
        System.out.println(1 + 2 * counter);
        counter++;
        if (counter >= num) return;
        odd(num, counter);
    }

    public void gcf(int num1, int num2)
    {
        int greater = num1 > num2 ? num1 : num2;  //Math.max() but idw use built in method
        int less = num1 < num2 ? num1 : num2;  //Math.min()
        if (num1 != num2) {
            greater = greater - less;
            gcf(greater, less);
        }
        else{
            System.out.println(greater);
        }
    }
}




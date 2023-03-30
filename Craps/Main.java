/*
 * David Lim
 * 9/14/22
 * Craps Game
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener{
    private int roll1;
    private int roll2;
    private int rollMax = 6;
    private int rollMin = 1;
    private int sum;
    JTextArea txaCraps = new JTextArea("", 10, 30);
    JButton btnRoll = new JButton("Roll");

    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public Main(){
        super("Craps");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(txaCraps);
        add(btnRoll);

        btnRoll.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        
        if (objSource == btnRoll){
            txaCraps.setText("");
            roll1 = (int)Math.floor(Math.random() * (rollMax - rollMin + 1) + rollMin);
            roll2 = (int)Math.floor(Math.random() * (rollMax - rollMin + 1) + rollMin);
            sum = roll1 + roll2;
            calculate calculate = new calculate(sum);

            int point = calculate.returnPoints();
            String outcome = calculate.getGameStatus();

            String outputString = "";

            outputString = "Roll 1: " + roll1 + "\t" + "Roll 2: " + roll2 + "\t" + "Sum: " + sum + "\n" +
            "Points: " + point + "\n" + 
            outcome;
            txaCraps.append(outputString);
        }
    }
    
}

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
    public static int gameswon = 0;
    public static int counter;
    JLabel lblLabel = new JLabel("How many games do you want to play:");
    JTextField txtNumofGames = new JTextField(10);
    JTextArea txaCraps = new JTextArea("", 10, 30);
    JButton btnPlay = new JButton("Play");

    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public Main(){
        super("Craps");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(lblLabel);
        add(txtNumofGames);
        add(txaCraps);
        add(btnPlay);


        btnPlay.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        
        if (objSource == btnPlay){
            txaCraps.setText("");
            int numofGames = Integer.parseInt(txtNumofGames.getText());
            String outputString = "";
            String string = "";

            for (counter=0; counter < numofGames;){
                roll1 = (int)Math.floor(Math.random() * (rollMax - rollMin + 1) + rollMin);
                roll2 = (int)Math.floor(Math.random() * (rollMax - rollMin + 1) + rollMin);
                sum = roll1 + roll2;
                roll roll = new roll(sum);

                String outcome = roll.getGameStatus();


            }
            // outputString += (gameswon / numofGames);
            outputString = "Win chance: " + Double.toString(((float)gameswon / (float)numofGames)* 100) + "%" + "\n" +
            "Number of Games: " + numofGames;
            txaCraps.append(outputString);
            counter = 0;
            gameswon = 0;
        }
    }
    
}

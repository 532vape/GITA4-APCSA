/*
 * David Lim
 * 12/5/22
 * Insert Array
 */

 //import statements
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
 
 public class Main extends JFrame implements ActionListener{
    JTextArea outputArea = new JTextArea("", 10, 15);
    JButton btnExecute = new JButton("Sequential");
    JTextField input = new JTextField(10);
    int[] numbers = new int[10];
    Quicksort quicksort = new Quicksort();
    Insert insert = new Insert();

    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public Main(){
        //application bar name
        super("Sequential & Binary Search");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //layout manager
        setLayout(new FlowLayout());

        add(input);
        add(outputArea);
        add(btnExecute);
        //add listener for button
        btnExecute.addActionListener(this);
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random() * 10 + 1);
        }

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        int numberToFind = Integer.parseInt(input.getText());
        if (objSource == btnExecute){
            outputArea.setText("");
            quicksort.Main(numbers);
            insert.Main(numbers, numberToFind);
            Insert.proceed = true;
            String newArray = Arrays.toString(insert.returnNewarr());
            outputArea.setText("Original Array: " + Arrays.toString(numbers) + "\n" + "Array with inserted value: " + newArray);
        }

    }
       
 }
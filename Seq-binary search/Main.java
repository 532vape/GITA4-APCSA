/*
 * David Lim
 * 9/27/22
 * 2D Arrays
 */

 //import statements
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 import java.text.DecimalFormat;
 import java.util.Arrays;
 
 public class Main extends JFrame implements ActionListener{
    int length = 5000;
    JTextArea outputArea = new JTextArea("", 20, 50);
    JButton btnSequential = new JButton("Sequential");
    JButton btnBinary = new JButton("Binary");
    JTextField inputx = new JTextField(10);
    int[] sequentialArray = new int[length];
    int[] binaryArray = new int[length];
    int num;
    int total;
    double sequentialSuccess;
    int sequentialSearches = 0;
    double average;
    double avgBin;
    int success = 0;
    double binarySuccess;
    int binarySearches;

    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

    public Main(){
        //application bar name
        super("Sequential & Binary Search");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //layout manager
        setLayout(new FlowLayout());

        add(inputx);
        add(outputArea);
        add(btnSequential);
        add(btnBinary);

        //add listener for button
        btnSequential.addActionListener(this);
        btnBinary.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();

        if (objSource == btnSequential){
            sequentialSearches += 5000;
            outputArea.setText(""); //refresh contents of text area on every btn click
            num = Integer.parseInt(inputx.getText());
            //search 5000 times
            for (int i = 0; i < length; i++){
                sequentialSearch(num);
            }
            average = sequentialSuccess / sequentialSearches;

            // System.out.println(average);
            // System.out.println(Arrays.toString(sequentialArray));
            // Arrays.sort(sequentialArray);
            // System.out.println(Arrays.toString(sequentialArray));
            outputArea.setText("");
        }

        if (objSource == btnBinary){
            binarySearches += 5000;
            outputArea.setText(""); //refresh contents of text area on every btn click
            num = Integer.parseInt(inputx.getText());
            //search 5000 times
            for (int i = 0; i < length; i++){
                binarySearch(binaryArray, num);
            }
            avgBin = binarySuccess / binarySearches;

            System.out.println(avgBin);
        }
    }
    //FIX AVERAGE!!!!!
    public void sequentialSearch(int numberToFind){
        //fill array with ints 1-5000
        for (int i = 0; i < length; i++){
            sequentialArray[i] = (int)(Math.random() * length + 1);
        }

        // System.out.println(Arrays.toString(sequentialArray));
        //iterate and search thru array
        for (int n = 0; n < sequentialArray.length; n++){
            if (sequentialArray[n] == num){
                sequentialSuccess += n;
                //why tf does the break break the average???????
            }
            
        }
        // System.out.println(sequentialSuccess);
    }


    public void binarySearch(int sortedArray[], int target){
        
        for (int i = 0; i < length; i++){
            sortedArray[i] = (int)(Math.random() * length + 1);
        }
        Arrays.sort(sortedArray);
        // System.out.println(Arrays.toString(sortedArray));
        int left = 0, right = sortedArray.length - 1, middle;
        int counter = 0;
        while (left <= right){
            middle = (left + right) / 2;
            if(target > sortedArray[middle]){
                left = middle + 1;
            }
            else if(target < sortedArray[middle]){  //basically just compareTo()
                right = middle - 1;
            }
            else if (target == sortedArray[middle]){
                binarySuccess += counter;
                System.out.println(counter);
                break;
            }
            counter++;
            
        }
    }
 }
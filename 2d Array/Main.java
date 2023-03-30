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
    // int x;
    // int y;
    int myArray[][];
    int countArray[] = new int[51];
    int total;  //track average score
    //screen components 
    JTextArea outputArea = new JTextArea("", 20, 50);
    JButton btnCalculate = new JButton("Calculate");
    JTextField inputx = new JTextField(10);
    JTextField inputy = new JTextField(10);
    int highest = 50;
    int lowest = 100;
    float avg;
    int size;
    int currentnum;

    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }

    public Main(){
        //application bar name
        super("Test Score");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //layout manager
        setLayout(new FlowLayout());

        add(inputx);
        add(inputy);
        add(outputArea);
        add(btnCalculate);

        //add listener for button
        btnCalculate.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();

        if (objSource == btnCalculate){
            outputArea.setText(""); //refresh contents of text area on every btn click
            int x = Integer.parseInt(inputx.getText());
            int y = Integer.parseInt(inputy.getText());
            myArray = new int[x][y];
            String outputString = "";
            for (int b = 0; b < x; b++){
                for (int h = 0; h < y; h++){
                    myArray[b][h] = (int)(Math.random()*50) + 50;
                    total+=myArray[b][h];
                    size += 1;
                }
            }
            
            for (int i = 0; i < x; i++){
                for (int n = 0; n < y; n++){
                    if(myArray[i][n] < lowest){
                        lowest = myArray[i][n];
                    }
                    if(myArray[i][n] > highest){
                        highest = myArray[i][n];
                    }
                    currentnum = myArray[i][n] - 50;
                    countArray[currentnum] += 1;

                }
            }
            avg = (float)(total / size);
            // System.out.print(Arrays.deepToString(myArray));
            // System.out.println(highest);
            // System.out.println(lowest);
            // System.out.println(total);
            // System.out.println(avg);
            // System.out.println(Arrays.toString(countArray));
            outputString += "Highest number: " + highest;
            outputString += "\n" + "Lowest number: " + lowest;
            outputString += "\n" + "Average value: " + avg + "\n";
            for(int i = 50; i < countArray.length + 50; i++){
                outputString += i + ": " + countArray[i - 50] + "\t";
                if(i % 10 ==0){
                    outputString += "\n";
                }
            }
            outputArea.setText(outputString);
        }
    }

 }
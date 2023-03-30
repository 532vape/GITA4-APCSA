/*
 * David Lim
 * 9/8/22
 * Test Score program
 */

 //import statements
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionListener;
 import java.awt.event.ActionEvent;
 import java.text.DecimalFormat;
import java.util.Arrays;
 
 public class Main extends JFrame implements ActionListener{

    static float avg;  //track average score
    int percentArray[] = new int[5];
    char gradeArray[] = new char[5];
    //screen components 
    JTextField numofTests = new JTextField(20);
    JTextArea outputArea = new JTextArea("", 20, 50);
    JButton btnCalculate = new JButton("Calculate");
    JLabel txtEarned = new JLabel("Points Earned");
    JTextField pointsEarnedField = new JTextField(10);
    JLabel txtTotal = new JLabel("Total Points Possible");
    JTextField pointsTotalField = new JTextField(10);
    DecimalFormat f = new DecimalFormat("##.00");

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

        //add screen components
        // add(txtEarned);
        // add(pointsEarnedField);
        // add(txtTotal);
        // add(pointsTotalField);
        add(numofTests);
        add(outputArea);
        add(btnCalculate);

        //add listener for button
        btnCalculate.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        int pointsEarned, pointsTotal; //declare variables for points earned and total points possible on an assignment

        if (objSource == btnCalculate){
            outputArea.setText(""); //refresh contents of text area on every btn click
            int tests = Integer.parseInt(numofTests.getText());
            System.out.print(tests);
            percentArray = new int[tests];
            gradeArray = new char[tests];

            // //grab strings from textboxes and convert into integers for calculation
            // pointsEarned = Integer.parseInt(pointsEarnedField.getText());
            // pointsTotal = Integer.parseInt(pointsTotalField.getText());    
            //create calculate class object and feed in inputs
            int totalscore = 0;
            int highestScore = 0;
            int lowestScore = 100;
            String outputString = "";
            outputString += "Percent and Letter Grade: ";
            for (int i=0;i<percentArray.length;i++){
                double rand = Math.random();
                percentArray[i] = (int)(Math.random() * 100);
                // System.out.print(percentArray[i]);
                if (percentArray[i] < lowestScore){
                    lowestScore = percentArray[i];
                }
                if (percentArray[i] > highestScore){
                    highestScore = percentArray[i];
                }
                calculate calculate = new calculate(percentArray[i], 100);
                gradeArray[i] = calculate.getLetterGrade();
                // System.out.print(gradeArray[i]);
                totalscore+=percentArray[i];
                outputString += percentArray[i] + "-" + Character.toString(gradeArray[i]) + ", ";
            }
            outputString += "\n" + "Average Score: " + (totalscore/percentArray.length);
            outputString += "\n" + "Highest Score: " + highestScore + "\t" + "Lowest Score: " + lowestScore;
            // System.out.println(totalscore);
            // System.out.println(percentArray.length);
            outputString += "\n" + "Reverse Order: ";
            for (int i = gradeArray.length-1; i >= 0; i--){
                outputString += gradeArray[i] + ", ";
            }
            //grab results from calculation class and assign to variables
            // char letterGrade = calculate.getLetterGrade();
            // float highestScore = calculate.getTopScore();
            // float avg = calculate.getAvg();

            //ouput
            // outputString = "Score: " + pointsEarned + "/" + pointsTotal + "\n" +
            // "Letter Grade: " + letterGrade + "\n" + 
            // "Highest Score (%): " + f.format(highestScore * 100) + "\n" + 
            // "Average Score (%): " + f.format(avg * 100);
            outputArea.append(outputString);
        }
    }

 }
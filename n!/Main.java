/*
 * David Lim
 * 9/20/22
 * N!
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener{
    JTextArea txaOutput = new JTextArea("", 10, 30);
    JButton btnSum = new JButton("Sums");
    JButton btnSumOdd = new JButton("Odd Sums");
    JButton btnSumEven = new JButton("Even Sums");
    JButton btnFactorial = new JButton("Factorial");
    JTextField textFieldInput = new JTextField(10);
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    private int count;
    private int sum;
    private String num = "";
    private int sumOdd;
    private String numOdd = "";
    private int sumEven;
    private String numEven = "";
    private int factorial = 1;
    private String numFactorial = "";
    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public Main(){
        super("N!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        
        
        add(panel1);
        panel1.add(txaOutput);
        add(textFieldInput);

        add(panel);
        panel.add(btnSum);
        panel.add(btnSumEven);
        panel.add(btnSumOdd);
        panel.add(btnFactorial);

        btnSum.addActionListener(this);
        btnSumOdd.addActionListener(this);
        btnSumEven.addActionListener(this);
        btnFactorial.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        String outputString = "";

        count = Integer.parseInt(textFieldInput.getText());
        if (objSource == btnSum){
            sum = 0;
            num = "";
            sum(count);
            txaOutput.setText("");
            outputString = "Sum: " + returnSum() + "\n" + "Numbers:" + returnNum();
            txaOutput.append(outputString);
        }
        else if(objSource == btnSumOdd){
            sumOdd = 0;
            numOdd = "";
            sumOdd(count);
            txaOutput.setText("");
            outputString = "Sum (odds): " + returnSumOdd() + "\n" + "Numbers:" + returnNumOdd();
            txaOutput.append(outputString);
        }
        else if(objSource == btnSumEven){
            sumEven = 0;
            numEven = "";
            sumEven(count);
            txaOutput.setText("");
            outputString = "Sum (even): " + returnSumEven() + "\n" + "Numbers:" + returnNumEven();
            txaOutput.append(outputString);
        }
        else if(objSource == btnFactorial){
            factorial = 1;
            numFactorial = "";
            factorial(count);
            txaOutput.setText("");
            outputString = "Factorial: " + returnFactorial() + "\n" + "Numbers:" + returnNumFactorial();
            txaOutput.append(outputString);
        }
    }

    private void sum(int n){
        int count = n;
        for (int i = 1; i<=count;i++){
            sum += i;
            num += " " + i;
        }
    }

    private void sumOdd(int n){
        int count = n;
        for (int i=0; i <= count*2; i ++){
            if (i % 2 == 1){
                sumOdd += i;
                numOdd += " " + i;
            }
        }
    }

    private void sumEven(int n){
        int count = n;
        for (int i=1; i <= count*2; i ++){
            if (i%2 == 0){
                sumEven += i;
                numEven += " " + i;
            }
        }
    }

    private void factorial(int n){
        int count = n;
        for (int i=1; i <= count; i ++){
            factorial *= i;
            numFactorial += " " + i;
        }
    }

    public int returnSum(){
        return sum;
    }

    public String returnNum(){
        return num;
    }

    public int returnSumOdd(){
        return sumOdd;
    }

    public String returnNumOdd(){
        return numOdd;
    }

    public int returnSumEven(){
        return sumEven;
    }

    public String returnNumEven(){
        return numEven;
    }

    public int returnFactorial(){
        return factorial;
    }

    public String returnNumFactorial(){
        return numFactorial;
    }


    
}

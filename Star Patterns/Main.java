/*
 * David Lim
 * 9/26/22
 * Star Patterns
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.security.cert.X509CRLSelector;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener{
    JTextArea txaOutput = new JTextArea("", 10, 30);
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    String[][] starArray = new String[10][10];
    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public Main(){
        super("Star Patterns");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(txaOutput);
        add(btn1);
        add(btn2);
        add(btn3);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        String outputString = "";

        if (objSource == btn1){
            for(int i=1; i <= 10; i ++){
                for(int x=1; x <= i; x++){
                    outputString += "*" ;
                }
                outputString+="\n";
                txaOutput.setText(outputString);
            }
        }

        if (objSource == btn2){
            for (int i=1; i<=10; i++){
                for(int x=10; x>=i; x--){
                    outputString += "*";
                }
                outputString+="\n";
                txaOutput.setText(outputString);
            }
        }

        if (objSource == btn3){
            for (int i=1; i<=10; i++){
                for(int x=1; x<=i; x++){
                    outputString += "  ";
                    
                }
                for(int k=10; k>i; k--){
                    outputString += "*";
                }
                outputString+="\n";
                txaOutput.setText(outputString);
            }
        }
    }
}

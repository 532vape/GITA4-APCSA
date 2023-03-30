/*
 * David Lim
 * 1/20/22
 * Palindrome + Bob
 */

//import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener {
    JTextArea outputArea = new JTextArea("Enter text.", 10, 15);
    JButton run = new JButton("Run");
    JTextField input = new JTextField(10);
    String text;
    Palindrome palindrome = new Palindrome();
    Bob bob = new Bob();
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setSize(600, 500);
        frame.setVisible(true);
    }

    public Main() {
        // application bar name
        super("Palindrome");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // layout manager
        setLayout(new FlowLayout());
        add(input);
        add(outputArea);
        add(run);
        // add listener for button
        run.addActionListener(this);
        run.setEnabled(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();
        if (objSource == run){
            outputArea.setText("");
            text = input.getText();
            // System.out.print(text);
            palindrome.Main(text);
            bob.Main(text);
            outputArea.setText(palindrome.returnResult() + "\n" +
            bob.returntext());
        }
    }
}

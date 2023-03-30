//Name: Mister S
//Date: 8/22/19
//Project Description
/* This project codes concatenation and how
 * to do buttons
 */


//awt. * it imports only those classes which belong
//exactly to java. awt package, not to its subpackages.
//That's why when you want to use events you have
//also import java.
//

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import java.time.*;
import java.util.Arrays;

public class Main extends JFrame implements ActionListener {


    //declare our components or fields
    //a field is a global level variable

    JTextField txtName = new JTextField(20);
    JTextField txtID = new JTextField(10);
    JTextField txtSalary = new JTextField(10);
    //Declare a text Area for output
    JTextArea txaPayRoll = new JTextArea(
            "Name" + "\t" + "ID" + "\t" + "Salary" + "\n", 10, 30);
    JButton btnAdd = new JButton("Add Employee");
    JButton btnOutput = new JButton("Output Employees");

    //Declare variables to hold information

    String nameString;

    //this creates and array of 3 employees;
    Employee[] employeeArray = new Employee[3];
    int employeeCount = 0;

    //main is the first method that runs

    public static void main(String[] args) {

        //declare our frame which is a form
        Main frame = new Main();
        frame.setSize(500, 500);
        frame.setVisible(true);


    }

    //Declare a constructor for the project
    //The constructor initializes the object
    public Main() {

        //put a title bar on the frame
        super("Button Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set our layout manager
        setLayout(new FlowLayout());
        //add our components to the frame
        add(new JLabel("Name:   "));
        add(txtName);

        add(new JLabel("Employee ID:     "));
        add(txtID);

        add(new JLabel("Salary: "));
        add(txtSalary);
        add(btnAdd);
        add(btnOutput);
        //add the text Area
        add(txaPayRoll);

        //add the liseners
        btnAdd.addActionListener(this);
        btnOutput.addActionListener(this);
        txtName.addActionListener(this);
        txtID.addActionListener(this);
        txtSalary.addActionListener(this);


    }

    //when you push the button, the code comes here
    public void actionPerformed(ActionEvent event) {

        //declare our local variables
        String employeeName;
        String employeeID;
        double salaryDouble;

        //listen for which button being pressed
        Object objSource = event.getSource();

        if (objSource == btnAdd) {

            try {


                //get information from text boxes
                employeeName = txtName.getText();

                employeeID = txtID.getText();

                salaryDouble = Double.parseDouble(txtSalary.getText());

                //connect to the object
                Employee theEmployee = new Employee();
                theEmployee.setName(employeeName);
                theEmployee.setID(employeeID);
                theEmployee.setSal(salaryDouble);

                //put information into the array
                employeeArray[employeeCount] = theEmployee;
                employeeCount++;


                //clear out text boxes
                txtName.setText("");
                txtID.setText("");
                txtSalary.setText("");

                //place cursor back to starting position
                txtName.requestFocus();
            } catch (NumberFormatException err) {

                txaPayRoll.setText("Data Error!");
            }


        }
        if (objSource == btnOutput) {

            if(employeeArray.length > 0){
                for(int i = 0; i < employeeArray.length; i++){
                    txaPayRoll.append(employeeArray[i].getName() + "\t" + employeeArray[i].getId() +
                            "\t" + employeeArray[i].getSalary() + "\n");
                }
            }
        }

    }


}//last brace of project





/*David Lim
 8/31/2022 
 Car Rental Upgrade
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends  JFrame implements ActionListener{

	//declare our components or fields
	// a field is a global level variable
  	double totalcost;
  	double totalpeople;
  	double avgcost;
	JTextField txtName = new JTextField(10);
	JTextField txtAddress = new JTextField(20);
	JTextField txtCity = new JTextField(5);
	JTextField txtState = new JTextField(5);
	JTextField txtZipcode = new JTextField(5);
	JTextField txtStartodometer = new JTextField(5);
	JTextField txtEndodometer = new JTextField(5);
	JTextField txtDays = new JTextField(5);
	//declare textArea
	JTextArea txaPayroll = new JTextArea("",10,30);
	JButton btnAdd = new JButton("Calculate");
	
	//declare variables to hold information.
  
	
	
	
	//main is the first method to run - method means function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declare a frame for form
		Main frame = new Main();
		frame.setSize(500,500);
		frame.setVisible(true);

	}
	//declare constructor for the project
	//The constructor sets everything up.
	public Main() 
	{
		//name at the top bar of application
		super("Car Rental Upgrade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set layout manager
		setLayout(new FlowLayout());

		//screen components
		add(new JLabel("Name:"));
		add(txtName);
		add(new JLabel("Address:"));
		add(txtAddress);
		add(new JLabel("City:"));
		add(txtCity);
		add(new JLabel("State:"));
		add(txtState);
		add(new JLabel("Zip code:"));
		add(txtZipcode);
		add(new JLabel("Starting odometer:"));
		add(txtStartodometer);
		add(new JLabel("Ending odometer:"));
		add(txtEndodometer);
		add(new JLabel("Days Rented:"));
		add(txtDays);
		add(btnAdd);
		add(txaPayroll);

		//add listener to the button
		btnAdd.addActionListener(this);
		
	}//end of constructor
	
	//when you push the button - the code comes here
	
	public void actionPerformed(ActionEvent event) 
	{
		Object objSource = event.getSource();
		
		if(objSource == btnAdd) 
		{
			//variable setup
			txaPayroll.setText("");
			String nameString = "";
     		double startOdometer;
     		double endOdometer;
     		double daysRented;
      		double cost;
      		startOdometer = Double.parseDouble(txtStartodometer.getText());
			endOdometer = Double.parseDouble(txtEndodometer.getText());
      		daysRented = Double.parseDouble(txtDays.getText());

			//initialize classes for calculations and formatting
			LocalFormat format = new LocalFormat();
			CalculationsClass calculate = new CalculationsClass(startOdometer, endOdometer, daysRented);

			//get values from the calculation class
      		double miles = calculate.getMiles();
      		cost = calculate.getCost();
      		totalcost = calculate.getTotal();
      		totalpeople = calculate.getEmployeeCount();
      		avgcost = calculate.getAvg();
			String outputString = "";

			//get information from textboxes
			nameString = txtName.getText();

			//concatenate the text together
			outputString = "Customer Info: " + "\n" + "Name: " + nameString +"\t" + "Address: " + txtAddress.getText() + ", " + txtCity.getText() + ", " + txtState.getText() + " " + txtZipcode.getText() + "\n" +
			 "Rental Details: " + "\n" + "Miles: " + Math.floor(miles) + "\t" + "Cost: " + format.FormatCurrency(cost) + "\n" +
			 "Manager Stats: " + "\n" + "Average Cost: " + format.FormatCurrency(avgcost) + "\t" + "Total People: " + totalpeople;

			//output to the text area
			txaPayroll.append(outputString);
			
			//clear text boxes
			txtName.setText("");
			txtCity.setText("");
			txtAddress.setText("");
			txtName.requestFocus();
		}
		
	}

}//end of class
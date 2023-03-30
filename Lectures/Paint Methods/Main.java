

//Name: Mister S
//Date: 10/29/18
/*
 * This project codes a timer
 * and animation
 */



import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import java.awt.event.*;



public class Main extends JFrame implements ActionListener{
	
	
	
	//timer buttons
	JButton btnStart = new JButton("Start");
	JButton btnStop = new JButton("Stop");
	
	//Location variables for circle
	int intX = 50;
	int intY = 200;

	int intXAmount = 10;

	boolean OnorOff = false;

	Timer myTimer = new Timer(100, this);
	
	
	
	//create the init method
	//the init is the first method to run
	
	public Main(){
		
		
		super("Button Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		//pnlInput.setLayout(new GridLayout(0,2));
		add(btnStart);
		add(btnStop);

		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		
		repaint();
		
		
		
	}
	
	

	public static void main(String[]args){
		
		//Place components on the applet panel
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 500;
		
		Main frame = new Main();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		
		     
	}
	//when you push the button it comes this method
	public void actionPerformed(ActionEvent event){
		
		//declare variable to hold which button is called
		Object objsource = event.getSource();
		//requestFocus();

		if (objsource == btnStop){
			stopTheTimer();
		}
		else if (objsource == btnStart){
			startTheTimer();
		}
		if(OnorOff){
			if(intX > getWidth()){
				intXAmount *= - 1;
			}
			else if(intX < 0){
				intXAmount *= -1;
			}

			intX += intXAmount;
			repaint();
		}
		 
			
			
			
		
		
	}
	
	
	
	
	//create the paint method to show graphics
	public void paint(Graphics g){
		
		super.paint(g);
		
		g.setColor(Color.red);
		g.fillOval(intX,intY,50,50);
		
	}
	public void Update(Graphics gr){
		
		//call the paint method
		paint(gr);
	}
	
	public void startTheTimer(){
		myTimer.start();
		OnorOff = true;
	}
	
	public void stopTheTimer(){
		myTimer.stop();
		OnorOff = false;
	}

}




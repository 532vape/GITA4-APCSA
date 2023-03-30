

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

	DefineObject Circles[] = new DefineObject[50];

	private Graphics2D buffer;
	private Image offscreen;
	
	
	
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
		for (int j = 0; j<Circles.length; j++){
			Circles[j] = new DefineObject();
		}
		//give the array its properties
		for (int i = 0; i < Circles.length; i++){
			int xpos, ypos, xspeed, yspeed;
			xpos = (int)(Math.random()*450);
			ypos = (int)(Math.random()*450);

			Circles[i].setCircle(xpos, ypos, "Red");
		}
		
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
			for (int m = 0; m < Circles.length; m++){
				Circles[m].xDist += Circles[m].velX;
				Circles[m].yDist += Circles[m].velY;
			}
			repaint();
		}
		
	}
	
	
	
	
	//create the paint method to show graphics
	public void paint(Graphics g){
		
		offscreen = createImage(getSize().width, getSize().height);
		buffer = (Graphics2D)offscreen.getGraphics();		
		for(int n = 0; n < Circles.length; n++){
			buffer.setColor(Color.red);
			buffer.fillOval(Circles[n].xDist, Circles[n].yDist, 5, 5);

			if(Circles[n].xDist <=0){
				Circles[n].velX*=-1;
			}
			else if (Circles[n].xDist >= 495){
				Circles[n].velX*=-1;
			}
			if(Circles[n].yDist <=0){
				Circles[n].velY*=-1;
			}
			else if (Circles[n].yDist >= 495){
				Circles[n].velY*=-1;
			}
		}
		g.drawImage(offscreen, 0, 0, this);
		
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




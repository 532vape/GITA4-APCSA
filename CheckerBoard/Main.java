

//Name: David Lim
//Date: 9/29/22
/*
 * Checkerboard
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
	// int intX = 50;
	// int intY = 200;
	
	JTextField txtfieldRows = new JTextField("5", 5);
    JTextField txtfieldCols = new JTextField("5", 5);
    JLabel lblRows = new JLabel("# of rows");
    JLabel lblCols = new JLabel("# of columns");
    JButton btnDraw = new JButton("Draw");

    int columns = 5;
    int rows = 5;
	


	
	
	
	
	//create the init method
	//the init is the first method to run
	
	public Main(){
		
		
		super("Button Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		//pnlInput.setLayout(new GridLayout(0,2));
		
        add(lblCols);
		add(txtfieldCols);
        add(lblRows);
        add(txtfieldRows);
        add(btnDraw);

        btnDraw.addActionListener(this);
		repaint();
        
		
		
		
	}
	
	

	public static void main(String[]args){
		
		//Place components on the applet panel
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;
		
		Main frame = new Main();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);

		
		     
	}
	//when you push the button it comes this method
	public void actionPerformed(ActionEvent event){
		
		//declare variable to hold which button is called
		Object objSource = event.getSource();
		//requestFocus();
        if(objSource == btnDraw){
            repaint();
            System.out.println("PAINT");
        }
		
		
		 
			
			
			
		
		
	}
	
	
	
	
	//create the paint method to show graphics
	public void paint(Graphics g){
		rows = Integer.parseInt(txtfieldRows.getText());
        columns = Integer.parseInt(txtfieldCols.getText());

		super.paint(g);
        for(int x = 1; x <= columns; x++){
            for(int y = 1; y <= rows; y++){
                if (y % 2 == 1 && x % 2 == 1){
                    g.setColor(Color.black);
                    g.fillRect(x*50 + 50, y*50 + 50,50,50);
                }
                else if (y % 2 == 0 && x % 2 == 0){
                    g.setColor(Color.black);
                    g.fillRect(x*50 + 50, y*50 + 50,50,50);
                }
                if (y % 2 == 0 && x % 2 == 1){
                    g.setColor(Color.white);
                    g.fillRect(x*50 + 50, y*50 + 50,50,50);
                }
                else if (y % 2 == 1 && x % 2 == 0){
                    g.setColor(Color.white);
                    g.fillRect(x*50 + 50, y*50 + 50,50,50);
                }
      
            }
        }
		
	}
	public void Update(Graphics gr){
		
		//call the paint method
		paint(gr);
	}
	
	
	

}




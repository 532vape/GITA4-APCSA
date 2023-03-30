

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
import java.util.ArrayList;


public class Main extends JFrame implements ActionListener{



    //timer buttons
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JButton btnAdd = new JButton("a");
    JButton btnPop = new JButton("r");
    //Location variables for circle
    int intX = 50;
    int intY = 200;

    int intXAmount = 10;

    boolean OnorOff = false;

    Timer myTimer = new Timer(100, this);

    ArrayList<DefineObject> Circles = new ArrayList<>();

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
        add(btnAdd);
        add(btnPop);

        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
        btnAdd.addActionListener(this);
        btnPop.addActionListener(this);

        for (int j = 0; j< 50; j++){
            Circles.add(new DefineObject());
        }
        //give the array its properties
        for (DefineObject circle : Circles) {
            int xpos, ypos, xspeed, yspeed;
            xpos = (int) (Math.random() * 450);
            ypos = (int) (Math.random() * 450);

            circle.setCircle(xpos, ypos, "Red");
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
        Object source = event.getSource();
        //requestFocus();

        if (source == btnStop){
            stopTheTimer();
            System.out.print("sad");
        }
        else if (source == btnStart){
            startTheTimer();
        }
        else if (source == btnAdd) {
            int next = Circles.size();
            Circles.add(new DefineObject());
            Circles.get(next).setCircle((int) (Math.random() * 450), (int) (Math.random() * 450), "Red");
            repaint();
        }
        else if (source == btnPop){
            Circles.remove(Circles.size() - 1);
            repaint();
        }
        if(OnorOff){
            for (DefineObject circle : Circles) {
                circle.xDist += circle.velX;
                circle.yDist += circle.velY;
            }
            repaint();
        }

    }




    //create the paint method to show graphics
    public void paint(Graphics g){

        offscreen = createImage(getSize().width, getSize().height);
        buffer = (Graphics2D)offscreen.getGraphics();
        for (DefineObject circle : Circles) {
            buffer.setColor(Color.red);
            buffer.fillOval(circle.xDist, circle.yDist, 5, 5);

            if (circle.xDist <= 0) {
                circle.velX *= -1;
            } else if (circle.xDist >= 495) {
                circle.velX *= -1;
            }
            if (circle.yDist <= 0) {
                circle.velY *= -1;
            } else if (circle.yDist >= 495) {
                circle.velY *= -1;
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




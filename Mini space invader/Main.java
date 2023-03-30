
//Name: David Lim
//Date: 10/23/22
/*
* space invader
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

public class Main extends JFrame implements KeyListener, ActionListener {

  // declare our componets or fields
  // a field is a global level variable.

  int intXAmount = 10;
  int speedX = 10;
  int speedY = 10;
  int playerX = 50;
  int playerY = 400;

  int invaderX = 200;
  int invaderY = 50;
  int invadervelX = 5;
  int invadervelY = 5;
  int invaderlives = 3;

  int bulletspeed = 20;
  int bulletX = playerX + 20;
  int bulletY = playerY + 20;
  boolean bulletMove = false;

  boolean hit = false;

  Timer invaderTimer = new Timer(50, this);
  boolean timerState = true;
  private Graphics2D buffer;
	private Image offscreen;

  public Main() {

    super("Mini space invader");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    // pnlInput.setLayout(new GridLayout(0,2));
    invaderTimer.start();
	invaderTimer.addActionListener(this);
    addKeyListener(this);

  }

  public static void main(String[] args) {

    // Place components on the applet panel
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    Main frame = new Main();
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setVisible(true);

  }

  // when you push the button it comes this method
  public void actionPerformed(ActionEvent event) {

    // declare variable to hold which button is called

      if (invaderX >= 460){
        invadervelX *=-1;
      }
      else if (invaderX <= 0){
        invadervelX *=-1;
      }
      if (invaderY <20){
        invadervelY *=-1;
      }
      else if (invaderY >=460){
        invadervelY*=-1;
      }
      invaderX += invadervelX;
      invaderY += invadervelY;

    
    requestFocus();
	  repaint();
  }

  // create the paint method to show graphics
  public void paint(Graphics g) {

	  offscreen = createImage(getSize().width, getSize().height);
    buffer = (Graphics2D)offscreen.getGraphics();
    buffer.setColor(Color.red);
    buffer.fillRect(playerX, playerY, 50, 50);

    buffer.setColor(Color.black);
    buffer.fillRect(bulletX, bulletY, 10,10);

    buffer.setColor(Color.blue);
    buffer.fillRect(invaderX, invaderY, 40, 40);
	  g.drawImage(offscreen, 0, 0, this);

    
    if (bulletMove == true){
      bulletY -= bulletspeed;
      if (bulletY <= 0){
        bulletY = playerY + 20;
        bulletX = playerX + 20;
        bulletMove = false;
      }
    }

    boolean check = checkHit(bulletX, bulletY, invaderX, invaderY);
    if (check){
      bulletY = playerY + 20;
      bulletX = playerX + 20;
      bulletMove = false;
      invaderlives -= 1;
      System.out.println(invaderlives);
      hit = false;
    }

    if (invaderlives <= 0){
      invaderY = 20;
    }
  }

  public void Update(Graphics gr) {
    // call the paint method
    paint(gr);
  }

  public void keyPressed(KeyEvent e) {

    int key = e.getKeyCode();
    // nameTextField.setText(""+ key);
    if (key == 37 && playerX >= 20) {
      playerX -= speedX;
      if (!bulletMove){
        bulletX -= speedX;
      }
    }
    if (key == 39 && playerX + 50 <= 480) {
      playerX += speedX;
      if (!bulletMove){
      bulletX += speedX;
      }
    }
    if (key == 32){
      bulletMove = true;
    }
  }

  public void keyReleased(KeyEvent e) {
    // nameTextField.setText("");
  }

  public void keyTyped(KeyEvent e) {

  }

  public boolean checkHit(int bulletx, int bullety, int invaderx, int invadery){
    if (bulletx >= invaderx && bulletx + 10 <= invaderx + 40 && bullety >= invadery && bullety + 10 <= invadery + 40 && bulletMove){
      hit = true;
    }
    return hit;

  }

}
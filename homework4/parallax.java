/***************
Homework #4
Due Date: 3/22/2019
Names:Nathan Flack, Evan Swanson
********************/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

/**
   This applet simulation motion parallax
*/

public class parallax extends JApplet
{
   private int currentX = 300; // Mouse cursor's X position (initialied to middle)
   private int currentY = 200; // Mouse cursor's Y position
   private Image image1;
   private Image image2;
   private Image image3;
   private Image image4;
    private Image image5;
	private Timer myTimer;
   /**
      init method
   */

   public void init()
   {
	  int delay = 33;
      try
      {
      image1 = ImageIO.read(new File("1.png"));
      image2 = ImageIO.read(new File("2.png"));
      image3 = ImageIO.read(new File("3.png"));
      image4 = ImageIO.read(new File("4.png"));
	  image5 = ImageIO.read(new File("5.png"));
      }
      catch(IOException e)
      {
         System.out.println("Error opening image files");
      }
      // Create a layout manager.
      setLayout(new FlowLayout());

      // Add a mouse listener to this applet.
      addMouseListener(new MyMouseListener());

      // Add a mouse motion listener to this applet.
      addMouseMotionListener(new MyMouseMotionListener());

	  myTimer = new Timer(delay, new MyTimerListener());
	  myTimer.start();
   }

    /**
      paint method
      @param g The applet's Graphics object.
   */

   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      //Paint each layer of the image with offset depending on mouse position
      g.drawImage(image1, -100, -100, null);
      g.drawImage(image2, (currentX / 150) - 80, (currentY / 150) - 100, null);
      g.drawImage(image3, (currentX / 30) - 100, (currentY / 30) - 100, null);
      g.drawImage(image4, (currentX / 5) - 100, (currentY / 5) - 100, null);

   }


   /**
      Private inner class that handles mouse events.
   */

   private class MyTimerListener implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   repaint();
	   }
   }

   private class MyMouseListener implements MouseListener
   {
      public void mouseClicked(MouseEvent e)
      {

      }
      public void mousePressed(MouseEvent e)
      {

      }
      public void mouseReleased(MouseEvent e)
      {

      }

      public void mouseEntered(MouseEvent e)
      {
		  myTimer.start();
      }

      public void mouseExited(MouseEvent e)
      {
		  myTimer.stop();
      }
   }

   /**
      Private inner class to handle mouse motion events.
   */

   private class MyMouseMotionListener implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {

      }

      public void mouseMoved(MouseEvent e)
      {
         //Update draw position and redraw to screen
         currentX = e.getX();
         currentY = e.getY();
      }
   }
}

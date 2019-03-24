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
   This applet shows the mouse events as they occur.
*/

public class parallax extends JApplet
{
   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   private Image image1;
   private Image image2;
   private Image image3;
   private Image image4;
   
   /**
      init method
   */
      
   public void init()
   {
      try
      {
      image1 = ImageIO.read(new File("1.png"));
      image2 = ImageIO.read(new File("2.png"));
      image3 = ImageIO.read(new File("3.png"));
      image4 = ImageIO.read(new File("4.png"));
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
   }

    /**
      paint method
      @param g The applet's Graphics object.
   */
   
   public void paint(Graphics g)
   {
      // Call the superclass's paint method.
      super.paint(g);
      g.drawImage(image1, -40, -40, null);
      g.drawImage(image2, -40, -40, null);
      g.drawImage(image3, -40, -40, null);
      g.drawImage(image4, -40, -40, null);
      
      //

      // Draw
      //boolean Graphics.drawImage(Image img, int x, int y, ImageObserver observer);
   }
   
   
   
   /**
      Private inner class that handles mouse events.
      When an event occurs, the text field for that
      event is given a yellow background.
   */
   
   private class MyMouseListener
                         implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {

      }

      public void mouseClicked(MouseEvent e)
      {
   
      }

      public void mouseReleased(MouseEvent e)
      {

      }

      public void mouseEntered(MouseEvent e)
      {

      }

      public void mouseExited(MouseEvent e)
      {

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

      }
   }
}

/***************
Homework #4
Due Date: 3/22/2019
Names:Nathan Flack, Evan Swanson
********************/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
   This applet shows the mouse events as they occur.
*/

public class parallax extends JApplet
{
   private int currentX = 0; // Mouse cursor's X position
   private int currentY = 0; // Mouse cursor's Y position
   
   /**
      init method
   */
      
   public void init()
   {
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
   
   private class MyMouseMotionListener
                         implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {

      }

      public void mouseMoved(MouseEvent e)
      {

      }
   }
}
/***************
Homework #3
Due Date: 2/24/2019
Names:Nathan Flack, Evan Swanson
********************/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class tictactoe extends JFrame
{
	private JPanel panel;

	private final int WINDOW_WIDTH = 310;  // Window width
	private final int WINDOW_HEIGHT = 310;

	private JButton topLeft;
	private JButton topCenter;
	private JButton topRight;
	private JButton middleLeft;
	private JButton middleCenter;
	private JButton middleRight;
	private JButton bottomLeft;
	private JButton bottomCenter;
	private JButton bottomRight;

	ImageIcon Ximage = new ImageIcon("X.png");
	ImageIcon Oimage = new ImageIcon("O.png");

	public tictactoe()
	{
		   // Set the title.
		setTitle("Tic Tac Toe");

		   // Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		   // Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		   // Build the panel and add it to the frame.
		buildPanel();

		   // Add the panel to the frame's content pane.
		add(panel);

		   // Display the window.
		setVisible(true);
	}

	private void buildPanel()
	{


		topLeft = new JButton("");
 	   	topCenter = new JButton("");
 	   	topRight = new JButton("");
		middleLeft = new JButton("");
 	   	middleCenter = new JButton("");
 	   	middleRight = new JButton("");
		bottomLeft = new JButton("");
 	   	bottomCenter = new JButton("");
 	   	bottomRight = new JButton("");

		topLeft.addActionListener(new TicTacToeListener());
 	   	topCenter.addActionListener(new TicTacToeListener());
 	   	topRight.addActionListener(new TicTacToeListener());
		middleLeft.addActionListener(new TicTacToeListener());
 	   	middleCenter.addActionListener(new TicTacToeListener());
 	   	middleRight.addActionListener(new TicTacToeListener());
		bottomLeft.addActionListener(new TicTacToeListener());
 	   	bottomCenter.addActionListener(new TicTacToeListener());
 	   	bottomRight.addActionListener(new TicTacToeListener());

		panel = new JPanel();

		panel.setLayout(new GridLayout(3,3));

		panel.add(topLeft);
		panel.add(topCenter);
		panel.add(topRight);
		panel.add(middleLeft);
		panel.add(middleCenter);
		panel.add(middleRight);
		panel.add(bottomLeft);
		panel.add(bottomCenter);
		panel.add(bottomRight);
	}

	private class TicTacToeListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
		   if (e.getSource() == topLeft)
           {
			   topLeft.setIcon(Oimage);
		   }
		   else if (e.getSource() == topCenter)
           {

		   }
		   else if (e.getSource() == topRight)
           {

		   }
		   else if (e.getSource() == middleLeft)
           {

		   }
		   else if (e.getSource() == middleCenter)
           {

		   }
		   else if (e.getSource() == middleRight)
           {

		   }
		   else if (e.getSource() == bottomLeft)
           {

		   }
		   else if (e.getSource() == bottomCenter)
           {

		   }
		   else if (e.getSource() == bottomRight)
           {

		   }
       }
    }

	public static void main(String[] args)
   	{
      	new tictactoe();
   	}
}

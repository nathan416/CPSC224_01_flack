/***************
Homework #3
Due Date: 2/25/2019
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
		setLayout(new GridLayout(3,3));

		topLeft = new JButton("");
 	   	topCenter = new JButton("");
 	   	topRight = new JButton("");
		middleLeft = new JButton("");
 	   	middleCenter = new JButton("");
 	   	middleRight = new JButton("");
		bottomLeft = new JButton("");
 	   	bottomCenter = new JButton("");
 	   	bottomRight = new JButton("");

		panel = new JPanel();

		panel.add(topLeft);
		panel.add(topCenter);
		panel.add(topRight);
		panel.add(middleLeft);
		panel.add(middleCenter);
		panel.add(middleRight);
		panel.add(bottomLeft);
		panel.add(bottomCenter);
		panel.add(bottomRight);

		topLeft.setSize(30,30);
	}
	public static void main(String[] args)
   	{
      	new tictactoe();
   	}
}

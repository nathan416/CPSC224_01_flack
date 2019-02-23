/***************
ICA #4
Due Date: 2/24/2019
Names:Nathan Flack
********************/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class DieRoll extends JFrame
{
	private JPanel panel;

	private final int WINDOW_WIDTH = 310;  // Window width
	private final int WINDOW_HEIGHT = 310;

	private JButton rightDie;
	private JButton leftDie;

	ImageIcon Die1 = new ImageIcon("Die1.png");
	ImageIcon Die2 = new ImageIcon("Die2.png");
	ImageIcon Die3 = new ImageIcon("Die3.png");
	ImageIcon Die4 = new ImageIcon("Die4.png");
	ImageIcon Die5 = new ImageIcon("Die5.png");
	ImageIcon Die6 = new ImageIcon("Die6.png");

	public DieRoll()
	{
		   // Set the title.
		setTitle("Die Roll");

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
		leftDie = new JButton("");
 	   	rightDie = new JButton("");

		leftDie.addActionListener(new TicTacToeListener());
 	   	rightDie.addActionListener(new TicTacToeListener());

		panel = new JPanel();

		panel.setLayout(new GridLayout(3,3));

		panel.add(leftDie);
		panel.add(rightDie);
	}

	private class TicTacToeListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {

       }
    }

	public static void main(String[] args)
   	{
      	new DieRoll();
   	}
}

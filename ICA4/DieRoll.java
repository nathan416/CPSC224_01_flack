/***************
ICA #4
Due Date: 2/24/2019
Names:Nathan Flack
********************/
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DieRoll extends JFrame
{
	private JPanel panel;

	private	JLabel dieLabel1;
	private	JLabel dieLabel2;

	private final int WINDOW_WIDTH = 310;  // Window width
	private final int WINDOW_HEIGHT = 310;

	private JButton rollButton;

	private ImageIcon Die1 = new ImageIcon("Die1.png");
	private ImageIcon Die2 = new ImageIcon("Die2.png");
	private ImageIcon Die3 = new ImageIcon("Die3.png");
	private ImageIcon Die4 = new ImageIcon("Die4.png");
	private ImageIcon Die5 = new ImageIcon("Die5.png");
	private ImageIcon Die6 = new ImageIcon("Die6.png");

	private Random rand;

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
		rollButton = new JButton("Roll the Dice");

		rollButton.addActionListener(new DieRollListener());

		panel = new JPanel();

		panel.add(dieLabel1);
		panel.add(dieLabel2);
		panel.add(rollButton);
	}

	private class DieRollListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
		   	rand = new Random();
		   	int n = rand.nextInt(5);
		   	int m = rand.nextInt(5);
			if (n == 0)
			{
				dieLabel1.setIcon(Die1);
			}
			else if (n == 1)
			{
				dieLabel1.setIcon(Die2);
			}
			else if (n == 2)
			{
				dieLabel1.setIcon(Die3);
			}
			else if (n == 3)
			{
				dieLabel1.setIcon(Die4);
			}
			else if (n == 4)
			{
				dieLabel1.setIcon(Die5);
			}
			else if (n == 5)
			{
				dieLabel1.setIcon(Die6);
			}
			if (m == 0)
			{
				dieLabel2.setIcon(Die1);
			}
			else if (m == 1)
			{
				dieLabel2.setIcon(Die2);
			}
			else if (m == 2)
			{
				dieLabel2.setIcon(Die3);
			}
			else if (m == 3)
			{
				dieLabel2.setIcon(Die4);
			}
			else if (m == 4)
			{
				dieLabel2.setIcon(Die5);
			}
			else if (m == 5)
			{
				dieLabel2.setIcon(Die6);
			}
       }
    }

	public static void main(String[] args)
   	{
      	new DieRoll();
   	}
}

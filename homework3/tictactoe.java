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
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JPanel topPanel;

	private final int WINDOW_WIDTH = 500;  // Window width
	private final int WINDOW_HEIGHT = 500;

	private JButton topLeft;
	private JButton topCenter;
	private JButton topRight;
	private JButton middleLeft;
	private JButton middleCenter;
	private JButton middleRight;
	private JButton bottomLeft;
	private JButton bottomCenter;
	private JButton bottomRight;

	private JTextField player1Name;
	private JTextField player2Name;
	private JLabel player1Wins;
	private JLabel player2Wins;
	private JLabel player1Losses;
	private JLabel player2Losses;
	private JLabel playerWins;
	private JLabel playerLosses;
	private JLabel playerName;



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

		setLayout(new BorderLayout());

		   // Build the panel and add it to the frame.
		buildPanel();
		buildPlayer1Panel();
		buildPlayer2Panel();

		   // Add the panel to the frame's content pane.
		add(panel, BorderLayout.CENTER);
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());

		topPanel.add(player1Panel, BorderLayout.NORTH);
		topPanel.add(player2Panel, BorderLayout.NORTH);
		add(topPanel, BorderLayout.NORTH);

		   // Display the window.
		setVisible(true);
	}

	private void buildPlayer1Panel()
	{
		player1Name = new JTextField(8);
		player1Wins = new JLabel("0");
		player1Losses = new JLabel("0");
		playerWins = new JLabel("Wins:	");
		playerLosses = new JLabel("Losses:	");
		playerName = new JLabel("Name:	");

		player1Panel = new JPanel();
		player1Panel.setSize(50,20);
		player1Panel.setLayout(new GridLayout(3,2));
		player1Panel.add(playerName);
		player1Panel.add(player1Name);
		player1Panel.add(playerWins);
		player1Panel.add(player1Wins);
		player1Panel.add(playerLosses);
		player1Panel.add(player1Losses);
	}

	private void buildPlayer2Panel()
	{
		player2Name = new JTextField(8);
		player2Wins = new JLabel("0");
		player2Losses = new JLabel("0");
		playerWins = new JLabel("Wins:	");
		playerLosses = new JLabel("Losses:	");
		playerName = new JLabel("Name:	");

		player2Panel = new JPanel();
		player2Panel.setSize(50,20);
		player2Panel.setLayout(new GridLayout(3,2));
		player2Panel.add(playerName);
		player2Panel.add(player2Name);
		player2Panel.add(playerWins);
		player2Panel.add(player2Wins);
		player2Panel.add(playerLosses);
		player2Panel.add(player2Losses);
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

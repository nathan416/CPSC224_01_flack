/***************
Homework #3
Due Date: 2/24/2019
Names:Nathan Flack, Evan Swanson
********************/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



public class tictactoe extends JFrame
{
	private JPanel panel;
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel bottomButtons;
	private JPanel statusBar;

	private final int WINDOW_WIDTH = 500;  // Window width
	private final int WINDOW_HEIGHT = 500;
	private int playerTurn = 1;		//Keep track of whose turn it is
	private boolean gameInProgress = false;

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

	private JButton newGame;
	private JButton resetGame;
	private JButton exitGame;
	private JLabel statusMessage;



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
		buildBottomPanel();

		   // Add the panel to the frame's content pane.
		add(panel, BorderLayout.CENTER);
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());

		topPanel.add(player1Panel, BorderLayout.NORTH);
		topPanel.add(player2Panel, BorderLayout.NORTH);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		   // Display the window.
		setVisible(true);
	}

	private void buildBottomPanel()
	{
		bottomPanel = new JPanel();
		statusBar = new JPanel();
		bottomButtons = new JPanel();
		newGame = new JButton("New Game");
		exitGame = new JButton("Exit");
		resetGame = new JButton("Reset");
		statusMessage = new JLabel("Welcome to Tic-Tac-Toe!");

		exitGame.addActionListener(new TicTacToeListener());
		newGame.addActionListener(new TicTacToeListener());
		resetGame.addActionListener(new TicTacToeListener());

		bottomPanel.setLayout(new BorderLayout());

		Border border = BorderFactory.createEtchedBorder();
		statusBar.setBorder(border);
		statusBar.add(statusMessage);
		bottomButtons.add(newGame);
		bottomButtons.add(resetGame);
		bottomButtons.add(exitGame);
		bottomPanel.add(bottomButtons, BorderLayout.CENTER);
		bottomPanel.add(statusBar, BorderLayout.SOUTH);
	}

	private void buildPlayer1Panel()
	{
		player1Name = new JTextField("Player 1", 8);
		player1Wins = new JLabel("0");
		player1Losses = new JLabel("0");
		playerWins = new JLabel("Wins:	");
		playerLosses = new JLabel("Losses:	");
		playerName = new JLabel("Name:	");

		player1Name.addActionListener(new TicTacToeListener());

		player1Panel = new JPanel();
		player1Panel.setSize(50,20);
		player1Panel.setLayout(new GridLayout(3,2));
		Border border = BorderFactory.createTitledBorder("Player 1 (X)");
		player1Panel.setBorder(border);
		player1Panel.add(playerName);
		player1Panel.add(player1Name);
		player1Panel.add(playerWins);
		player1Panel.add(player1Wins);
		player1Panel.add(playerLosses);
		player1Panel.add(player1Losses);
	}

	private void buildPlayer2Panel()
	{
		player2Name = new JTextField("Player 2",8);
		player2Wins = new JLabel("0");
		player2Losses = new JLabel("0");
		playerWins = new JLabel("Wins:	");
		playerLosses = new JLabel("Losses:	");
		playerName = new JLabel("Name:	");

		player2Name.addActionListener(new TicTacToeListener());

		player2Panel = new JPanel();
		player2Panel.setSize(50,20);
		player2Panel.setLayout(new GridLayout(3,2));
		Border border = BorderFactory.createTitledBorder("Player 2 (O)");
		player2Panel.setBorder(border);
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
		   if(gameInProgress)
		   {
				if (e.getSource() == topLeft)
				{
					if (topLeft.getIcon() != Ximage && topLeft.getIcon() != Oimage) //ensure it is not one that has already been clicked
					{
							if (playerTurn == 1) //determine whose turn it is and set the image
							{
									topLeft.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									topLeft.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}
				}
				else if (e.getSource() == topCenter)
				{
					if (topCenter.getIcon() != Ximage && topCenter.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									topCenter.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									topCenter.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}
				}
				else if (e.getSource() == topRight)
				{
					if (topRight.getIcon() != Ximage && topRight.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									topRight.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									topRight.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}
				}
				else if (e.getSource() == middleLeft)
				{
					if (middleLeft.getIcon() != Ximage && middleLeft.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									middleLeft.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									middleLeft.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}

				}
				else if (e.getSource() == middleCenter)
				{
					if (middleCenter.getIcon() != Ximage && middleCenter.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									middleCenter.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									middleCenter.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}

				}
				else if (e.getSource() == middleRight)
				{
					if (middleRight.getIcon() != Ximage && middleRight.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									middleRight.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									middleRight.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}

				}
				else if (e.getSource() == bottomLeft)
				{
					if (bottomLeft.getIcon() != Ximage && bottomLeft.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									bottomLeft.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									bottomLeft.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}
				}
				else if (e.getSource() == bottomCenter)
				{
					if (bottomCenter.getIcon() != Ximage && bottomCenter.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									bottomCenter.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									bottomCenter.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}
				}
				else if (e.getSource() == bottomRight)
				{
					if (bottomRight.getIcon() != Ximage && bottomRight.getIcon() != Oimage)
					{
							if (playerTurn == 1)
							{
									bottomRight.setIcon(Ximage);
									playerTurn = 2;
									statusMessage.setText(player2Name.getText() + "'s turn.");
							}
							else if (playerTurn == 2)
							{
									bottomRight.setIcon(Oimage);
									playerTurn = 1;
									statusMessage.setText(player1Name.getText() + "'s turn.");
							}
					}
				}
		   }

		   if (e.getSource() == player1Name)
		   {
				Border border = BorderFactory.createTitledBorder( player1Name.getText() +" (X)");
				player1Panel.setBorder(border);
		   }
		   else if (e.getSource() == player2Name)
		   {
				Border border = BorderFactory.createTitledBorder( player2Name.getText() +" (O)");
				player2Panel.setBorder(border);
		   }
		   else if (e.getSource() == exitGame)
		   {
			   System.exit(0);
		   }
		   else if (e.getSource() == newGame)
		   {
			   gameInProgress = true;
			   player1Name.setEditable(false);
			   player2Name.setEditable(false);
			   statusMessage.setText(player1Name.getText() + "'s turn.");
			   topRight.setIcon(null);
			   topCenter.setIcon(null);
			   topLeft.setIcon(null);
			   middleLeft.setIcon(null);
			   middleRight.setIcon(null);
			   middleCenter.setIcon(null);
			   bottomLeft.setIcon(null);
			   bottomCenter.setIcon(null);
			   bottomRight.setIcon(null);
		   }
		   else if (e.getSource() == resetGame)
		   {
			   gameInProgress = false;
			
			   player1Name.setText("Player 1");
			   player1Name.setEditable(true);
			   player2Name.setText("Player 2");
			   player2Name.setEditable(true);

			   statusMessage.setText("Welcom to Tic-Tac-Toe");

				player1Losses.setText("0");
				player1Wins.setText("0");
				player2Losses.setText("0");
				player2Wins.setText("0");

			   topRight.setIcon(null);
			   topCenter.setIcon(null);
			   topLeft.setIcon(null);
			   middleLeft.setIcon(null);
			   middleRight.setIcon(null);
			   middleCenter.setIcon(null);
			   bottomLeft.setIcon(null);
			   bottomCenter.setIcon(null);
			   bottomRight.setIcon(null);
		   }
       }
    }

	public static void main(String[] args)
   	{
      	new tictactoe();
   	}
}

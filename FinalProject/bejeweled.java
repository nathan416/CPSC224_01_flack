/***************
Final Project
Demo Due Date: 4/19/2019
Due Date: 5/7/2019
Names:Nathan Flack, Evan Swanson
********************/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.util.Random;

public class bejeweled extends JFrame
{

	private JPanel bejeweledPanel;
	private JPanel HighscorePanel;
	private JPanel PointsPanel;
	private boolean turnActive = false;
	private int currentCol;
	private int currentRow;
	private char[][] boardInfo = new char[5][6];

	private final int WINDOW_WIDTH = 720;  // Window width
	private final int WINDOW_HEIGHT = 600;
	private final int squareSize = 120;

	private Image background = new ImageIcon("background.jpg");

	public bejeweled()
	{
		// Set the title.
	 setTitle("Bejeweled");

	 setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 setLayout(new BorderLayout());

	 buildBejeweledPanel();
	 //buildHighscorePanel();
	 //buildPointsPanel();
	 initializeBoard();

	 add(bejeweledPanel);
	}

	private void buildBejeweledPanel()
	{
		bejeweledPanel = new JPanel();

	}

	public void paint(Graphics g)
    {
		super.paint(g);
	}

	private void initializeBoard()
	{
		char[] orbs = {'G','R','B','D','L','H'};
		Random rand = new Random();
		int n = 0;

		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				n = rand.nextInt(6);
				boardInfo[i][j] = orbs[n];
			}
		}

	}

	private void swap(int homeRow, int homeCol, int destRow, int destCol)
	{
		char temp = boardInfo[homeRow][homeCol];
		boardInfo[homeRow][homeCol] = boardInfo[destRow][destCol];
		boardInfo[destRow][destCol] = temp;
	}

	private class boardListener implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			turnActive = true;
			currentCol = e.getX() / squareSize;
			currentRow = e.getY() / squareSize;
		}

		public void mouseClicked(MouseEvent e)
		{
		}

		public void mouseReleased(MouseEvent e)
		{
			turnActive = false;
		}

		public void mouseEntered(MouseEvent e)
		{
		}

		public void mouseExited(MouseEvent e)
		{
		}
	}


	private class boardMovementListener implements MouseMotionListener
	{
		public void mouseMoved(MouseEvent e)
		{
			int x = e.getX();
			int y = e.getY();

			if(turnActive)
			{
				if(currentCol != (x / squareSize))
				{
					swap(currentRow, currentCol, currentRow, (x / squareSize));
					currentCol = x / squareSize;
				}

				if(currentRow != (y / squareSize))
				{
					swap(currentRow, currentCol, (y / squareSize), currentRow);
					currentRow = y / squareSize;
				}
			}
		}

		public void mouseDragged(MouseEvent e)
		{
		}

	}

}

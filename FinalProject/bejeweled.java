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
import java.awt.image.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class bejeweled extends JApplet
{

	private JPanel bejeweledPanel;
	private JPanel HighscorePanel;
	private JPanel PointsPanel;
	private boolean turnActive = false;
	private int currentCol;
	private int currentRow;
	private char[][] boardInfo = new char[5][6];
	private int x;
	private int y;
	private int currentScore = 0;
	private int numOrbsMatched;
	private char currentColor;
	private Timer turnTimer;

	private final int WINDOW_WIDTH = 720;  // Window width
	private final int WINDOW_HEIGHT = 700;
	private final int squareSize = 120;
	private JFrame theFrame = new JFrame();

	private Image background;
	private Image redOrb;
	private Image blueOrb;
	private Image greenOrb;
	private Image darkOrb;
	private Image lightOrb;
	private Image pinkOrb;

	private BufferedImage bf;


	public bejeweled()
	{
		// Set the title.
	 theFrame.setTitle("Bejeweled");

	 theFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	 //theFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	 theFrame.setLayout(new BorderLayout());
	 readImages();

	 buildBejeweledPanel();

	 //buildHighscorePanel();
	 //buildPointsPanel();
	 initializeBoard();

	 theFrame.add(bejeweledPanel, BorderLayout.CENTER);
	 theFrame.add(PointsPanel, BorderLayout.SOUTH);
	 turnTimer = new Timer(10000, new boardTimer());

	  // Add a mouse listener to this applet.
   addMouseListener(new boardListener());

   // Add a mouse motion listener to this applet.
   addMouseMotionListener(new boardMovementListener());
	}

	public int countCombos()
	{
		int totalCombos = 0;
		char[][] comboMap = new char[5][6];
		//initialize values
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 6; j++)
				comboMap[i][j] = 'o';
		}

		//find which orbs will be cleared
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 6; col++)
			{
				if(boardInfo[row][col] != '0' && isComboMember(row,col))
					comboMap[row][col] = 'X';
			}
		}
		
		//erase combos and increment counter
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 6; col++)
			{
				if(comboMap[row][col] == 'X' && boardInfo[row][col] != 'X')
				{
					eraseCombo(row,col,comboMap,boardInfo[row][col]);
					repaint();
					//try{
				//		Thread.sleep(1000);
				//	}
				//	catch(InterruptedException ex){}
					totalCombos += 1;
				}
			}
		}

		//perform orb cascades
		while(xExists())
		{
			for(int row = 4; row > -1; row--)
			{
				for(int col = 5; col > -1; col--)
				{
					if(boardInfo[row][col] == 'X')
					{
						skyFall(row,col);
					}
				}
			}
		}

		return totalCombos;

	}

	//cascades an orb if needed
	public void skyFall(int row, int col)
	{
		int pos = row;
		while(pos > 0)
		{
			boardInfo[pos][col] = boardInfo[pos - 1][col];
			pos--;
		}
		boardInfo[0][col] = '0';
	}

	//returns true if there is an X on the board
	public boolean xExists()
	{
		for(int row = 0; row < 5; row++)
		{
			for(int orb = 0; orb < 6; orb++)
			{
				if(boardInfo[row][orb] == 'X')
					return true;
			}
		}
		return false;
	}

	//returns true if the orb is part of a combo
	public boolean isComboMember(int row, int col)
	{
		//vertical current bottom
		if(row > 1)
		{
			if(boardInfo[row][col] == boardInfo[row - 1][col] && boardInfo[row][col] == boardInfo[row - 2][col])
				return true;
		}
		//vertical current middle
		if(row > 0 && row < 4)
		{
			if(boardInfo[row][col] == boardInfo[row - 1][col] && boardInfo[row][col] == boardInfo[row + 1][col])
				return true;
		}
		//vertical current top
		if(row < 3)
		{
			if(boardInfo[row][col] == boardInfo[row + 1][col] && boardInfo[row][col] == boardInfo[row + 2][col])
				return true;
		}
		//horizonal current left
		if(col < 4)
		{
			if(boardInfo[row][col] == boardInfo[row][col + 1] && boardInfo[row][col] == boardInfo[row][col + 2])
				return true;
		}
		//horizontal currrent middle
		if(col < 5 && col > 0)
		{
			if(boardInfo[row][col] == boardInfo[row][col + 1] && boardInfo[row][col] == boardInfo[row][col - 1])
				return true;
		}
		//horizontal current right
		if(col > 1)
		{
			if(boardInfo[row][col] == boardInfo[row][col - 1] && boardInfo[row][col] == boardInfo[row][col - 2])
				return true;
		}
		return false;
	}

	public void eraseCombo(int row, int col, char[][] comboMap, char comboColor)
	{
		if(boardInfo[row][col] == comboColor && comboMap[row][col] == 'X')
		{
			boardInfo[row][col] = 'X';
			if(row < 4)
			{
				eraseCombo(row+1, col, comboMap, comboColor);
			}
			if(row > 0)
			{
				eraseCombo(row-1, col, comboMap, comboColor);
			}
			if(col > 0)
			{
				eraseCombo(row, col-1, comboMap, comboColor);
			}
			if(col < 5)
			{
				eraseCombo(row, col+1, comboMap, comboColor);
			}
		}
	}

	public int performTurn()
	{
		char[] orbs = {'G','R','B','D','L','P'};
		Random rand = new Random();
		int n = 0;
		numOrbsMatched = 0;
		int totalCombos = countCombos();
		int temp = countCombos();
		//perform cascades
		while(temp != 0)
		{
			totalCombos += temp;
			temp = countCombos();
		}
		repaint();
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 6; col++)
			{
				if(boardInfo[row][col] == '0')
				{
					numOrbsMatched++;
					n = rand.nextInt(6);
					boardInfo[row][col] = orbs[n];
				}
			}
		}
		return totalCombos;
	}





  public void readImages () 
  { 
    try 
    {                
      background = ImageIO.read(new File("board.png"));
      redOrb = ImageIO.read(new File("red.png"));
      greenOrb = ImageIO.read(new File("green.png"));
			blueOrb = ImageIO.read(new File("blue.png"));
			darkOrb = ImageIO.read(new File("dark.png"));
			lightOrb = ImageIO.read(new File("light.png"));
			pinkOrb = ImageIO.read(new File("pink.png"));
    } 
    catch (IOException e) 
    { 
      //Not handled. 
    } 
  } 


	private void buildBejeweledPanel()
	{
		bejeweledPanel = new JPanel();
		PointsPanel = new JPanel();


	}

  public void update(Graphics g)
	{
		paint(g);
	}

	//build the buffered image
	public void animation(Graphics g)
	{
		super.paint(g);
		g.drawImage(background, 0, 0, null);
		float opacity = 0.5f;
		float fullOpacity = 1.0f;

		//draw each orb
		for(int row = 0; row < 5; row++)
		{
			for(int col = 0; col < 6; col++)
			{
				if (boardInfo[row][col] == 'R')
					g.drawImage(redOrb, col*squareSize, row*squareSize, null);
				else if (boardInfo[row][col] == 'B')
					g.drawImage(blueOrb, col*squareSize, row*squareSize, null);
				else if (boardInfo[row][col] == 'G')
					g.drawImage(greenOrb, col*squareSize, row*squareSize, null);
				else if (boardInfo[row][col] == 'D')
					g.drawImage(darkOrb, col*squareSize, row*squareSize, null);
				else if (boardInfo[row][col] == 'L')
					g.drawImage(lightOrb, col*squareSize, row*squareSize, null);
				else if (boardInfo[row][col] == 'P')
					g.drawImage(pinkOrb, col*squareSize, row*squareSize, null);
			}
		}

	

		//draw orb player is holding
		if(turnActive)
		{
			if(currentColor == 'R')
				g.drawImage(redOrb, x-60, y-60, null);
			if(currentColor == 'B')
				g.drawImage(blueOrb, x-60, y-60, null);
			if(currentColor == 'G')
				g.drawImage(greenOrb, x-60, y-60, null);
			if(currentColor == 'D')
				g.drawImage(blueOrb, x-60, y-60, null);
			if(currentColor == 'L')
				g.drawImage(lightOrb, x-60, y-60, null);
			if(currentColor == 'P')
				g.drawImage(pinkOrb, x-60, y-60, null);
		}
	}

	@Override
	public void paint(Graphics g)
  {
		//use a buffered image to eliminate flickering
		bf = new BufferedImage(WINDOW_WIDTH,WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
		try
		{
			animation(bf.getGraphics());
			g.drawImage(bf,0,0,null);
		}
		catch(Exception ex)
		{
		}
	}

	private void initializeBoard()
	{
		char[] orbs = {'G','R','B','D','L','P'};
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

	private class boardTimer implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			currentScore = 0;
			turnActive = false;
			turnTimer.stop();
			int matches = performTurn();
			currentScore = matches * numOrbsMatched;
			JOptionPane.showMessageDialog(null, "You scored: " + currentScore + "\nTotal Combos: " + matches);
		}
	}

	private class boardListener implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			turnActive = true;
			turnTimer.start();
			currentCol = e.getX() / squareSize;
			currentRow = e.getY() / squareSize;
			currentColor = boardInfo[currentRow][currentCol];
		}

		public void mouseClicked(MouseEvent e)
		{
		}

		public void mouseReleased(MouseEvent e)
		{
			if(turnActive)
			{
				currentScore = 0;
				turnActive = false;
				turnTimer.stop();
				int matches = performTurn();
				currentScore = matches * numOrbsMatched;
				JOptionPane.showMessageDialog(null, "You scored: " + currentScore + "\nTotal Combos: " + matches);
			}
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
		}

		public void mouseDragged(MouseEvent e)
		{
			x = e.getX();
			y = e.getY();

			if(turnActive)
			{
				if(currentCol != (x / squareSize))
				{
					swap(currentRow, currentCol, currentRow, (x / squareSize));
					currentCol = x / squareSize;
				}

				if(currentRow != (y / squareSize))
				{
					swap(currentRow, currentCol, (y / squareSize), currentCol);
					currentRow = y / squareSize;
				}
				repaint();
			}
			
		}

	}

}

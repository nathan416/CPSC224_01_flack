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

	private final int WINDOW_WIDTH = 720;  // Window width
	private final int WINDOW_HEIGHT = 600;
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

	 theFrame.add(bejeweledPanel);
	  // Add a mouse listener to this applet.
   addMouseListener(new boardListener());

   // Add a mouse motion listener to this applet.
   addMouseMotionListener(new boardMovementListener());
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
	}

	@Override
	public void paint(Graphics g)
  {
		//use a buffered image to eliminate flickering
		bf = new BufferedImage(720,600, BufferedImage.TYPE_INT_RGB);
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
					repaint();
				}

				if(currentRow != (y / squareSize))
				{
					swap(currentRow, currentCol, (y / squareSize), currentCol);
					currentRow = y / squareSize;
					repaint();
				}
			}
			
		}

	}

}

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

public class bejeweled extends JFrame
{

	private JPanel bejeweledPanel;
	private JPanel HighscorePanel;
	private JPanel PointsPanel;

	private final int WINDOW_WIDTH = 500;  // Window width
	private final int WINDOW_HEIGHT = 500;

	public bejeweled()
	{
		// Set the title.
	 setTitle("Bejeweled");

	 setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 setLayout(new BorderLayout());

	 buildBejeweledPanel();
	 buildHighscorePanel();
	 buildPointsPanel();
	}

	private void buildBejeweledPanel()
	{
		bejeweledPanel = new JPanel();
		
	}


}

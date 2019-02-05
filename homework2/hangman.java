/***************
Homework #2
Due Date: 2/11/2019
Names:Nathan Flack
********************/
import java.util.*;
import javax.swing.JOptionPane;

public class hangman
{
	public static void main(String [] args)
	{
		displayHangman(6);
	}

	public static void menu()
	{

	}

	public static void displayHangman(int strikes)
	{
		if (strikes == 0)
		{
			JOptionPane.showMessageDialog(null,"       ________\n       |                 |\n       |\n       |\n       |\n___|___\n");
		}
		else if (strikes == 1)
		{
			JOptionPane.showMessageDialog(null,"       ________\n       |                 |\n       |                0\n       |\n       |\n___|___\n");
		}
		else if (strikes == 2)
		{
			JOptionPane.showMessageDialog(null,"       ________\n       |                 |\n       |                0\n       |                |\n       |\n___|___\n");
		}
		else if (strikes == 3)
		{
			JOptionPane.showMessageDialog(null,"       ________\n       |                 |\n       |                0\n       |               /|\n       |\n___|___\n");
		}
		else if (strikes == 4)
		{
			JOptionPane.showMessageDialog(null,"       ________\n       |                 |\n       |                0\n       |               /|\n       |                 \\\n___|___\n");
		}
		else if (strikes == 5)
		{
			JOptionPane.showMessageDialog(null,"       ________\n       |                 |\n       |                0\n       |               /|\\\n       |                 \\\n___|___\n");
		}
		else if (strikes == 6)
		{
			JOptionPane.showMessageDialog(null,"       ________\n       |                 |\n       |                0\n       |               /|\\\n       |               /\\\n___|___\n");
		}
		else
		{

		}
	}
}

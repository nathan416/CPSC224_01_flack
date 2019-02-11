/***************
Homework #2
Due Date: 2/11/2019
Names:Nathan Flack, Evan Swanson
********************/
import java.util.*;
import javax.swing.JOptionPane;

public class hangman
{
	public static void main(String [] args)
	{
		int userOption = 1;
		userOption = displayMenu();
		while(userOption != 3)
		{
			while(userOption > 3 || userOption < 1)
			{
				JOptionPane.showMessageDialog(null, "Invalid input");
				userOption = displayMenu();
			}

			String theWord = "";

			if(userOption == 1)
				theWord = generateRandomWord();

			else
			{
				theWord = JOptionPane.showInputDialog("Enter the word: ");
				theWord = theWord.toLowerCase();
			}


			String currentState = "";
			for(int i = 0; i < theWord.length(); i++)
				currentState = currentState.concat("-");
			
			int strikes = 0;
			boolean gameWon = false;
			while(strikes < 7 && !gameWon)
			{
				char userGuess = getInput(currentState, theWord);
				currentState = updateStringState(currentState, theWord, userGuess);
				strikes = strikes + countStrike(theWord, userGuess);
				if(currentState.equals(theWord))
				{
					gameWon = true;
					JOptionPane.showMessageDialog(null, "Congratulations, you won!\n" + "The word was: " + theWord);
				}
				else
					displayHangman(strikes);
			}
			if(!gameWon)
				JOptionPane.showMessageDialog(null, "Sorry, you lost\n" + "The word was: " + theWord);

			userOption = displayMenu();
		}
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

	public static String generateRandomWord()
	{
		String[] words = {"goats" , "apple", "homework", "laptop", "internet"};
		Random rand = new Random();
		int n = rand.nextInt(5);
		return words[n];
	}

	public static int displayMenu()
	{
		String option = JOptionPane.showInputDialog("Enter an option:\n1) Play from a random word\n2)Play from user inputed word\n3)ExitGame");
		return Integer.parseInt(option);
	}

	public static String updateStringState(String currentState, String theWord, char userGuess)
	{
		for(int i =0; i < currentState.length(); i++)
		{
			if(theWord.charAt(i) == userGuess)
			{
				char[] myChars = currentState.toCharArray();
				myChars[i] = userGuess;
				currentState = String.valueOf(myChars);
			}
		}
		return currentState;
	}

	public static char getInput(String currentState, String theWord)
	{
		String userGuess = JOptionPane.showInputDialog("Guess a letter: \n" + currentState);
		userGuess = userGuess.toLowerCase();
		while(!Character.isLetter(userGuess.charAt(0)))
		{
			JOptionPane.showMessageDialog(null, "Invalid Input");
			userGuess = JOptionPane.showInputDialog("Guess a letter: \n" + currentState);
			userGuess = userGuess.toLowerCase();
		}
		return userGuess.charAt(0);

	}

	public static int countStrike(String theWord, char userGuess)
	{
		for(int i =0; i < theWord.length(); i++)
		{
			if(theWord.charAt(i) == userGuess)
			{
				return 0;
			}
		}
		return 1;
	}
}

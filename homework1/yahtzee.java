import java.util.*;

public class yahtzee
{
	public static void main(String [] args)
	{
		Scanner scnr;
		final int DICE_IN_PLAY = 5;
		int hand[];
		hand = new int [DICE_IN_PLAY];
		char playAgain = 'y';
		while (playAgain == 'y')
		{
		    string keep = "nnnnn"; //setup to roll all dice in the first roll
		    int turn = 1;
		    while (turn < 4 && keep != "yyyyy")
		    {
		        //roll dice not kept
		        for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
		        {
		            if (keep[dieNumber] != 'y')
		                hand[dieNumber] = rollDie();
		        }
		        //output roll
		        System.out.print("Your roll was: ");
		        for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
		        {
		            System.out.print(hand[dieNumber] + " ");
		        }
		        System.out.println();
		        //if not the last roll of the hand prompt the user for dice to keep
		        if (turn < 3)
		        {
		            System.out.print( "enter dice to keep (y or n) ");
		            cin >> keep;
		        }
		        turn++;
		    }
		    //start scoring
		    //hand need to be sorted to check for straights

		    sortArray(hand, DICE_IN_PLAY);
		    System.out.print( "Here is your sorted hand : ");
		    for (int dieNumber = 0; dieNumber < DICE_IN_PLAY; dieNumber++)
		        {
		            System.out.print( hand[dieNumber] + " ");
		        }
		        System.out.println();
		    //upper scorecard
		    for (int dieValue = 1; dieValue <=6; dieValue++)
		    {
		        int currentCount = 0;
		        for (int diePosition = 0; diePosition < 5; diePosition++)
		        {
		            if (hand[diePosition] == dieValue)
		                currentCount++;
		        }
		        System.out.print( "Score " + dieValue * currentCount + " on the ");
		        System.out.println( dieValue + " line");
		    }
		    //lower scorecard
		    if (maxOfAKindFound(hand) >= 3)
		    {
		        System.out.print( "Score " << totalAllDice(hand) << " on the ";
		        System.out.print( "3 of a Kind line\n");
		    }
		    else System.out.print( "Score 0 on the 3 of a Kind line\n");

		    if (maxOfAKindFound(hand) >= 4)
		    {
		        System.out.print( "Score " << totalAllDice(hand) << " on the ";
		        System.out.print( "4 of a Kind line\n");
		    }
		    else System.out.print( "Score 0 on the 4 of a Kind line\n");

		    if (fullHouseFound(hand))
		        System.out.print( "Score 25 on the Full House line\n");
		    else
		        System.out.print( "Score 0 on the Full House line\n");

		    if (maxStraightFound(hand) >= 4)
		        System.out.print( "Score 30 on the Small Straight line\n");
		    else
		        System.out.print( "Score 0 on the Small Straight line\n");

		    if (maxStraightFound(hand) >= 5)
		        System.out.print( "Score 40 on the Large Straight line\n");
		    else
		        System.out.print( "Score 0 on the Large Straight line\n");

		    if (maxOfAKindFound(hand) >= 5)
		        System.out.print( "Score 50 on the Yahtzee line\n");
		    else
		        System.out.print( "Score 0 on the Yahtzee line\n");

		    System.out.print( "Score " << totalAllDice(hand) << " on the ";
		    System.out.print( "Chance line\n");
		    System.out.print( "\nEnter 'y' to play again ";
		    cin >> playAgain;
		}
	}

	public static int rollDie()
	{
		int roll = rand() % 6 + 1;
		return roll;
	}

	public static int maxOfAKindFound(int hand[])
	{
		int maxCount = 0;
	    int currentCount;
		for (int dieValue = 1; dieValue <=6; dieValue++)
	    {
	        currentCount = 0;
	        for (int diePosition = 0; diePosition < 5; diePosition++)
	        {
	            if (hand[diePosition] == dieValue)
	                currentCount++;
	        }
	        if (currentCount > maxCount)
	            maxCount = currentCount;
	    }
		return maxCount;
	}

	public static int maxStraightFound(int hand[])
	{
		int maxLength = 1;
		int curLength = 1;
		for(int counter = 0; counter < 4; counter++)
		{
			if (hand[counter] + 1 == hand[counter + 1] ) //jump of 1
				curLength++;
			else if (hand[counter] + 1 < hand[counter + 1]) //jump of >= 2
				curLength = 1;
			if (curLength > maxLength)
				maxLength = curLength;
		}
		return maxLength;
	}

	public static Boolean fullHouseFound(int hand[])
	{
		Boolean foundFH = false;
		Boolean found3K = false;
		Boolean found2K = false;
		int currentCount ;
		for (int dieValue = 1; dieValue <=6; dieValue++)
		{
			currentCount = 0;
			for (int diePosition = 0; diePosition < 5; diePosition++)
			{
				if (hand[diePosition] == dieValue)
					currentCount++;
			}
			if (currentCount == 2)
				found2K = true;
			if (currentCount == 3)
				found3K = true;
		}
		if (found2K && found3K)
			foundFH = true;
		return foundFH;
	}

	public static int totalAllDice(int hand[])
	{
		int total = 0;
	    for (int diePosition = 0; diePosition < 5; diePosition++)
	    {
	        total += hand[diePosition];
	    }
	    return total;
	}

	public static void sortArray(int array[], int size)
	{
		Boolean swap;
		int temp;

		do
		{
		   swap = false;
		   for (int count = 0; count < (size - 1); count++)
		   {
			  if (array[count] > array[count + 1])
			  {
				 temp = array[count];
				 array[count] = array[count + 1];
				 array[count + 1] = temp;
				 swap = true;
			  }
		   }
		} while (swap);
	}
}

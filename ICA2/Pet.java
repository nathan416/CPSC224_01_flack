/***************
In Class Assignment
Due Date: 2/7/2019
Names:Nathan Flack
********************/
import java.util.*;

public class Pet
{
	private static String name;
	private static String animal;
	private static int age;

	public static void setName(String Name)
	{
		name = Name;
	}

	public static void setAnimal(String Animal)
	{
		animal = Animal;
	}

	public static void setAge(int Age)
	{
		age = Age;
	}

	public static String getName()
	{
		return name;
	}

	public static String getAnimal()
	{
		return animal;
	}

	public static int getAge()
	{
		return age;
	}
}

package FinalProject;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Hangman 
{
	//This is a test
	//Generates a random object for randomized variables
		static Random generator = new Random();
		static int StartChances = 7;
		int chances;
		String word;
		String definition;
		char[] filler;
	public void Hangman() throws IOException
	{
		//Creates the wordList database from the WordList class
				WordList wordguessing = new WordList();
				
		//Creates an int between 0-9 for the wordIndex
		int wordIndex = generator.nextInt(9);
		chances = 7;
		//Retrieves the word from the wordList database for the game
		word = wordguessing.getWord(wordIndex).toLowerCase();
		filler = new char[word.length()];
		WordList wordguessing1 = new WordList();
		definition = wordguessing1.getDef(wordIndex);
		int i = 0;
		while (i<word.length())
		{
			filler[i]='-';
		if(word.charAt(i)==' ')
		{
				filler[i]=' ';
		}
	i++;
	}

	}
	public String getDef()
	{
		chances --;
		return definition;
	}
	public String getWord()
	{
		return word;
	}
	public String getFiller()
	{
		String actFiller = new String(filler);
		return actFiller;
	}
	public int getChances()
	{
		return chances;
	}
	public void guess(String guess) throws IOException
	{
		//Holds all the entered variables for the current game
		guess = guess.toLowerCase();
		ArrayList<String> l = new ArrayList<String>();
		char actGuess = guess.charAt(0);
		l.add(guess);
		//Checks for char types for the char if it exists it reveals it to the user
		if(word.contains(guess+""))
		{
			for(int y =0;y<word.length();y++)
			{
				if(word.charAt(y)==actGuess)
				{
					filler[y]=actGuess;
				}
			}
		}
		//If not it takes away a chance
		else
		{
			chances--;
		}
	}
	public void guess() throws IOException
	{	
	System.out.print(filler);
	System.out.println("Chances remaining: "+chances);
	Scanner input = new Scanner(System.in);
	String clue;
	System.out.println("Use a chance for a clue?(Y/N)");
	clue= input.next();
	clue = clue.toUpperCase();
	if(clue.equals("Y")||clue.equals("YES"))
	{
		System.out.println("Here a definition of the word:"+definition);
		chances--;
	}
	else
	{
		//Variable to determine whether the player wants to play another game or not
	String play;
	//Holds all the entered variables for the current game
	ArrayList<Character> l = new ArrayList<Character>();
	while(chances>0)
	{


		//changes the input to lower case, checks the first letter, cannot enter more than a signle letter at a time
		char x=input.next().toLowerCase().charAt(0);
	
		
		if(l.contains(x))
		{
			System.out.println("Already entered!");
			continue;
		}
	
		l.add(x);
		//Checks for char types for the char if it exists it reveals it to the user
		if(word.contains(x+""))
		{
			for(int y =0;y<word.length();y++)
			{
				if(word.charAt(y)==x)
				{
					filler[y]=x;
				}
			}
		}
		//If not it takes away a chance
		else
		{
			chances--;
		}
		//Constantly checks if the word is complete
		if(word.equals(String.valueOf(filler)))
		{
			System.out.println(filler);
			System.out.println("You Won!");
			//Requests user input to play another game
			System.out.println("Would you like to play again?Y/N");
			play = input.next().toLowerCase();
			if(play.equals("y")||play.equals("yes"))
			{
				//Recursive statement for the game
				guess();
			}
			else if(play.equals("n")||play.equals("no"))
				//Exits program if not
				System.exit(0);
			
		}
		System.out.println(filler);
		System.out.println("Chances remaining:"+chances);
		if(chances ==0)
		{
			System.out.println("You lose!");
			System.out.println("Would you like to play again?Y/N");
			play = input.next().toLowerCase();
			if(play.equals("y")||play.equals("yes"))
			{
				guess();
			}
			else if(play.equals("n")||play.equals("no"))
				System.exit(0);
		}
	}
	}
	
	}
	

	
}

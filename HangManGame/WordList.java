package FinalProject;

import java.io.IOException;

public class WordList 
{
private Word[] wordList;



public WordList() throws IOException
		{
	//10 is the amount of words for the circular array
	//This is an auxiliary array twice the size of the data used
	wordList = new Word[10];
	wordList[0] = new Word("zephyr");
	wordList[1] = new Word("inordinate");
	wordList[2] = new Word("ornate");
	wordList[3] = new Word("cleave", "to adhere closely; stick; cling");
	wordList[4] = new Word("mammal");
	wordList[5] = new Word("executive", "a person or group of persons having administrative or supervisory authority in an organization.");
	wordList[7] = new Word("fluoride");
	wordList[8] = new Word("potassium");
	wordList[9] = new Word("apple", "the usually round, red or yellow, edible fruit of a small tree, Malus sylvestris, of the rose family.");
	}

public String getWord(int i)
{
	return wordList[i].getWord();
}
public String getDef(int i)
{
	return wordList[i].getDef();
}
public int getLength(int i)
{
	return wordList[i].getLength();
}


}

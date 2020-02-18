package FinalProject;

import java.io.IOException;




import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;






public class Word 
{
	protected String exactWord;
	protected String definition;
	protected int length;
	protected String asterix="*";
	
	
	public Word(String eWord) throws IOException
	{
		exactWord = eWord;
		length = eWord.length();
		Document doc = Jsoup.connect("https://en.oxforddictionaries.com/definition/"+eWord).get();
		 definition = doc.select("meta[name=description]").first().attr("content");
		 for(int i = 0; i<length; i++)
			{
				asterix += "*";
			}
		 while (definition.contains(eWord))
		 {
			 definition = definition.replaceAll(eWord, asterix);
		 }
		
	}
	public Word(String eWord, String defWord)
	{
		exactWord = eWord;
		length = eWord.length();
		definition = defWord;
		
	}
	public String getWord()
	{
		return exactWord;
	}
	public String getDef()
	{
		return definition;
	}
	public int getLength()
	{
		return length;
	}
	public void setDef(String def)
	{
		definition = def;
	}

}

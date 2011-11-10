package bruteForce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads in text from a given file.
 *
 */
public class MyFileReader
{
  private Scanner scanner;

  public MyFileReader()
  {
  }

  /**
   * Gets 6 letter words to be used as keys.
   * 
   * @param path - File path.
   * @return - List of 6 letter words.
   */
  public List<String> get_words(String path)
  {
    List<String> six_length_words = new ArrayList<String>();
   
    try
    {
      scanner = new Scanner(new FileInputStream(path), "UTF-8");
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      return null;
    }

    String word;
    while (scanner.hasNextLine())
    {
      word = scanner.nextLine();

      if (word.length() == 6)
      {
        six_length_words.add(word);
      }
    }

    return six_length_words;

  }

  
  /**
   * Gets top 100 common English words that have a length greater
   * than 2.  This method used to get all words in the dictiony.
   * 
   * @param path - File path.
   * @return - Top 100 common words.
   */
  public List<String> get_all(String path)
  {
    List<String> allWords = new ArrayList<String>();
    try
    {
      scanner = new Scanner(new FileInputStream(path), "UTF-8");
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
      return null;
    }
    
    while (scanner.hasNextLine())
    {
      String str = scanner.nextLine();
      
      if(str.length() > 2)
      {
        allWords.add(str);
      }
      //allWords.add(str);
    }

    return allWords;

  }

}
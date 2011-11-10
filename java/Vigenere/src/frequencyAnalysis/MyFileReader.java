package frequencyAnalysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFileReader
{
  private Scanner scanner;

  public MyFileReader()
  {
  }

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
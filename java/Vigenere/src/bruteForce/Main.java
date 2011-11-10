package bruteForce;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main
{
  public static void main(String[] args)
  {
    long start = System.currentTimeMillis();
    MyFileReader fr = new MyFileReader();
    List<String> sixLetterWords = fr
        .get_words("E:/Dropbox/programming/files/dictionary.txt");

    List<String> allWords = fr
        .get_all("E:/Dropbox/programming/files/common-words.txt");

    VigenereDecryption vd = new VigenereDecryption(sixLetterWords, allWords);
    vd.decrypt();
    Map<String, String> matches = vd.get_matches();
    print(matches);

    long end = System.currentTimeMillis() - start;

    System.out.println(end);

  }

  /**
   * Prints best match.
   * 
   * @param matches - Key plus text.
   */
  public static void print(Map<String, String> matches)
  {
    Iterator it = matches.entrySet().iterator();
    int i = 1;
    while (it.hasNext())
    {
      Map.Entry pairs = (Map.Entry) it.next();
      System.out.println(i + ": " + pairs.getKey() + " = " + pairs.getValue());
      i++;
    }

  }
}

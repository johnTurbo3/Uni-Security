package frequencyAnalysis;

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
        .get_words("../files/dictionary.txt");

    List<String> allWords = fr
        .get_all("../files/common-words.txt");

    CharGrouper cg = new CharGrouper();
    char[] groups = cg.get_groups();
    
    VigenereDecryption vd = new VigenereDecryption(allWords);
    vd.decrypt(groups);
    Map<String, String> matches = vd.get_matches();

    Iterator it = matches.entrySet().iterator();
    int i = 1;
    while (it.hasNext())
    {
      Map.Entry pairs = (Map.Entry) it.next();
      System.out.println(i + ": " + pairs.getKey() + " = " + pairs.getValue());
      i++;
    }

    long end = System.currentTimeMillis() - start;

    System.out.println(end);

  }
}

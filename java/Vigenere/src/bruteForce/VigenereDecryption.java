package bruteForce;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VigenereDecryption
{
  private final char[] CIPHER = "tuhnqzlgucaggrpgzmhozdjxsypsdbkkoielermHwgeblruhnblrkxscoefgozwrgyeyziggarsyuhnybllxdNlikyoaudkhmkaiexsywewvhrlskuuzxuamegahgfegacgknkysgydounwktgilwlitnrwttivufmreoomleyhnvgegydghryvfvkacpnykoutsuhnilrfbnmdhavhzoextsnpoftbrlifmersiyxnilikxluxuwgtcoejxeblrquojfkfhwyoietnj".toLowerCase().toCharArray();

  private List<String> six_letter_words;
  private List<String> all_words;
  private Map<String, String> bestMatch;

  public VigenereDecryption(List<String> sixLetterWords, List<String> allWords)
  {
    six_letter_words = sixLetterWords;
    all_words = allWords;
  }

  /**
   * Decrypts words and checks whether they contain any english words.
   */
  public void decrypt()
  {
    Map<String, String> matches = new HashMap<String,String>();
    
    for (String key : six_letter_words)
    {
      String decryptWord = new String(shift(key.toCharArray()));
      
      for(String word : all_words)
      {
        if(decryptWord.contains(word))
        {
          matches.put(key, decryptWord);
          break;
        }
      }
    }
    
    test_strength(matches);
  }
  
  /**
   * Tests with decryption contains the most words/best match.
   * @param matches - Key and what it decrypted the cipher text to.
   */
  private void test_strength(Map<String, String> matches)
  {
    Iterator it = matches.entrySet().iterator();
    int oldCount = 0;
    int newCount = 0;
    bestMatch = new HashMap<String,String>();
    
    while (it.hasNext())
    {
      Map.Entry<String,String> pairs = (Map.Entry) it.next();
      
      String key = pairs.getKey().toString();
      String cipher = pairs.getValue().toString();
      newCount = 0;
      
      for(String word : all_words)
      {
        if(cipher.contains(word))
        {
          newCount++;
        }
      }
      
      if(newCount > oldCount)
      {
        bestMatch.clear();
        bestMatch.put(key, cipher);
        oldCount = newCount;
      }
    }
  }
  
  public Map<String, String> get_matches()
  {
    return bestMatch;
  }

  
  /**
   * Applies the decryption/character shift.
   * @param charKey - Key.
   * @return - Decrypted cipher.
   */
  private char[] shift(char[] charKey)
  {
    char[] decryptArr = new char[CIPHER.length];

    for(int i = 0; i < CIPHER.length; i++)
    {
      char currentChar = charKey[i % 6];              // At last index, start again at the first
      int p = (CIPHER[i]-97) - (currentChar-97);      // Take away value shift (97 is where 'a' starts in ascii
      
      if(p < 0)
      {
        p = 26 + p + 97; 
      }
      else
      {
        p += 97;                
      }
      
      int newChar = p;        
      decryptArr[i] = (char) newChar; 
    }
    
    return decryptArr;
  }
}
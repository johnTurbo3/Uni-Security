package charGrouper;

import java.util.Vector;


/**
 * This class groups the characters of every 6 places in the cipher text,
 * and counts the most frequent one.  All six results are printed together.
 *
 */
public class CharGrouper
{
  private String cipher_text;

  public CharGrouper()
  {
    cipher_text = "tuhnqzlgucaggrpgzmhozdjxsypsdbkkoielermHwgeblruhnblrkxscoefgozwrgyeyziggarsyuhnybllxdNlikyoaudkhmkaiexsywewvhrlskuuzxuamegahgfegacgknkysgydounwktgilwlitnrwttivufmreoomleyhnvgegydghryvfvkacpnykoutsuhnilrfbnmdhavhzoextsnpoftbrlifmersiyxnilikxluxuwgtcoejxeblrquojfkfhwyoietnj"
        .toLowerCase();

  }
  
  public static void main(String[] args)
  {
    CharGrouper cg = new CharGrouper();
    System.out.println(cg.get_groups());
  }

  public char[] get_groups()
  {

    char[] charGroups = new char[6];

    Vector<Character> letters = new Vector<Character>();

    for (int j = 0; j < 6; j++)
    {
      letters.clear();
      for (int i = j; i < cipher_text.length(); i += 6)
      {
        letters.add(cipher_text.charAt(i));
      }

      char superChar = 0;
      int superCount = 0;

      for (Character testC : letters)
      {
        int count = 0;

        for (Character c : letters)
        {
          if (c == testC)
          {
            count++;
          }
        }
        if (count > superCount)
        {
          superChar = testC;
          superCount = count;
        }
      }
      charGroups[j] = superChar;
      
    }
    
    return charGroups;
  }

}

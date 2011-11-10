package keyLength;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Finds and prints possible key lengths. 
 *
 */
public class KeyLength
{
  private String cipherText;
  Map<String, Integer> group_map;
  Map<Integer, Integer> frequency_map;

  public static void main(String[] args)
  {
    KeyLength main = new KeyLength();
    main.get_groups();
    main.find_frequency();
    main.print_frequency();

  }

  public KeyLength()
  {

    cipherText = "tuhnqzlgucaggrpgzmhozdjxsypsdbkkoielermhwgeblruhnblrkxscoefgozwrgyeyziggarsyuhnybllxdnlikyoaudkhmkaiexsywewvhrlskuuzxuamegahgfegacgknkysgydounwktgilwlitnrwttivufmreoomleyhnvgegydghryvfvkacpnykoutsuhnilrfbnmdhavhzoextsnpoftbrlifmersiyxnilikxluxuwgtcoejxeblrquojfkfhwyoietnj"
        .toLowerCase();
    group_map = new HashMap<String, Integer>();
    frequency_map = new HashMap<Integer, Integer>();
  }

  public void get_groups()
  {
    for (int groupLength = 2; groupLength < cipherText.length(); groupLength++)
    {

      for (int strPos = 0; strPos < cipherText.length() - groupLength; strPos++)
      {
        String strGroup = cipherText.substring(strPos, strPos + groupLength);
        int count = -1;
        // Search cipher text.
        for (int i = 0; i < cipherText.length() - groupLength + 1; i++)
        {
          String cipherSection = cipherText.substring(i, i + groupLength);

          if (cipherSection.contains(strGroup))
          {
            count++;
          }
        }

        if (count > 0)
        {
          group_map.put(strGroup, count);
        }
      }
    }
  }

  public void print_frequency()
  {
    Iterator it = frequency_map.entrySet().iterator();

    while (it.hasNext())
    {
      Map.Entry pairs = (Map.Entry) it.next();
      System.out.println("Key length " + pairs.getKey() + " = "
          + pairs.getValue());
      it.remove(); // avoids a ConcurrentModificationException
    }
  }

  public void find_frequency()
  {
    Iterator it = group_map.entrySet().iterator();

    while (it.hasNext())
    {
      Map.Entry pairs = (Map.Entry) it.next();

      String key = (String) pairs.getKey();
      int num = (Integer) pairs.getValue();
      int lastIndex = cipherText.indexOf(key);

      for (int i = 0; i < num; i++)
      {
        int newIndex = cipherText.indexOf(key, lastIndex + 1);
        int spacing = newIndex - lastIndex;

        if (frequency_map.containsKey(spacing))
        {
          int j = frequency_map.get((Integer) spacing);
          frequency_map.put(spacing, j + 1);
        }
        else
        {
          frequency_map.put(spacing, 1);
        }
        lastIndex = newIndex;
      }

    }

  }

}

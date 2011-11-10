import java.util.Scanner;

public class CaesarCipher
{
  public static void main(String[] args)
  {
	  
	  String inputValue = "Khpsclzpljmlzvgfglqapdvlgsfypjyanpaxlzgmsjlskcpvxgjdalldptqlzpkplzjppklphklzgmoadlygfpsjlzpygvk";
	  
      char[] charArray = inputValue.toCharArray();
      char[] newArray = new char[charArray.length];

      for (int i = 1; i < 26; i++)
      {
        for (int j = 0; j < charArray.length; j++)
        {
          char letter = charArray[j];
          if (letter == 32)
          {
            newArray[j] = letter;
            continue;
          }
          else if(letter > 47  && letter < 58)
          {
            newArray[j] = number(letter, i);
          }
          else if(letter > 64 && letter < 91)
          {
            newArray[j] = uppercase(letter, i);
          }
          else if(letter > 96 && letter < 123)
          {
            newArray[j] = lowercase(letter, i);
          }
          else
          {
            newArray[j] = '@';
          }          
        }

        System.out.print("-" + Integer.toString(i) + ":");
        System.out.print(newArray);
        System.out.print("\n");
      }
    }
  

  private static char number(char letter, int shift)
  {
    letter -= shift;
    
    if(letter < 48)
    {
      letter += 10;
    }
    
    return letter;
  }

  private static char uppercase(char letter, int shift)
  {
    letter -= shift;
    
    if(letter < 65)
    {
      letter += 26;
    }
    
    return letter;
  }
  
  private static char lowercase(char letter, int shift)
  {
    letter -= shift;
    
    if(letter < 97)
    {
      letter += 26;
    }
    
    if(letter == 'x')
    {
    	letter = 'e';
    }
    
    return letter;
  }
}
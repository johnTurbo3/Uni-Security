import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main
{

  public static void main(String[] args)
  {
    long startTime = System.currentTimeMillis();

    int limit = (int)Math.pow(16, 6);             // The amount of keys needed.
    int end1 = limit / 4;                         // Split the task up for 4 files
    int end2 = limit / 2;
    int end3 = limit / 2 + end1;
    int end4 = limit;
    int i = 0;                                   // Keeps track of which key to start from
    
    i = print_file(i, end1, 1);
    i = print_file(i, end2, 2);
    i = print_file(i, end3, 3);
    i = print_file(i, end4, 4);
    
    long endTime = System.currentTimeMillis();
    
    System.out.println("Execution time: " + (endTime-startTime));
  }

  /**
   * Used to split the file writing into 4 files.
   * Make keys until end is reached.  Then return the last key number.
   * Next file with start producing keys from the returned value (last key 
   * produced by the last method call).
   * 
   * @param i - Number to start making keys form.
   * @param end - Loop limit.
   * @param suffix - Output number.
   * @return - Last key number
   */
  public static int print_file(int i, int end, int suffix)
  {
    String original = "9dd52a9db9";

    try
    { 
      FileWriter fstream;
      BufferedWriter out;
      
      fstream = new FileWriter("output" + suffix + ".txt", false);
      out = new BufferedWriter(fstream);
      for (; i < end; i++)
      {
        String hexVal = Integer.toHexString(i);

        while (hexVal.length() != 6)
        {
          hexVal = "0" + hexVal;
        }
        
        out.write(original + hexVal  + "\n");
      }
      out.close();

     
    }
    catch (Exception e)
    {
      System.err.println("Error: " + e.getMessage());
    }
    return i;
  }
  
  
}
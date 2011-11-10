package Test;

import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class Decrypter implements Runnable
{
  private Formatter formatter_;
  private byte[] textEncrypted_;
  private Scanner scanner_;
  private String message, filePath;

  public Decrypter(String message, String filePath, int num)
  {
    formatter_ = new Formatter();
    this.message = message;
    this.filePath = filePath;
  }

  /**
   * Opens file containing keys.
   * 
   * @param filePath
   */
  private void open_file(String filePath)
  {
    try
    {
      scanner_ = new Scanner(new FileInputStream(filePath), "UTF-8");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void run()
  {
    long start = System.currentTimeMillis();

    textEncrypted_ = formatter_.hex_to_bytes(message);      // Converts cipher text to bytes.

    open_file(filePath);

    while (scanner_.hasNextLine())                          // Reads in keys
    {
      String strKey = scanner_.nextLine();
      byte[] key = formatter_.hex_to_bytes(strKey);         // Convert key to bytes
      
      try
      {
        KeySpec spec = new DESKeySpec(key);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        SecretKey myDesKey = factory.generateSecret(spec);                //Format DES key

        Cipher decipher = Cipher.getInstance("DES/ECB/PKCS5Padding");    // Specify decryption method
        
        decipher.init(Cipher.DECRYPT_MODE, myDesKey);

        // Decrypt the text twice
        byte[] textDecrypted1 = decipher.doFinal(textEncrypted_);
        byte[] textDecrypted2 = decipher.doFinal(textDecrypted1);

        System.out.println("Text Decryted : " + new String(textDecrypted2));
        System.out.println("Key: " + strKey + "\n");
      }
      catch (NoSuchAlgorithmException e)
      {
        //e.printStackTrace();
      }
      catch (NoSuchPaddingException e)
      {
        //e.printStackTrace();
      }
      catch (InvalidKeyException e)
      {
        //e.printStackTrace();
      }
      catch (IllegalBlockSizeException e)
      {
        //e.printStackTrace();
      }
      catch (BadPaddingException e)
      {
        //e.printStackTrace();

      }
      catch (Exception e)
      {
        //e.printStackTrace();
      }
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
  }


}

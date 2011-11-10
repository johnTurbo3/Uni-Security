package Test;

public class Formatter
{

  /**
   * Converts a hexadecimal string to an array of bytes.
   * 
   * @param hex - Hexadecimal string.
   * @return - Byte array.
   */
  public byte[] hex_to_bytes(String hex)
  {
    if (hex == null)
    {
      return null;
    }
    else if (hex.length() < 2)
    {
      return null;
    }
    else
    {
      int len = hex.length() / 2;
      byte[] buffer = new byte[len];
      for (int i = 0; i < len; i++)
      {
        buffer[i] = (byte) Integer
            .parseInt(hex.substring(i * 2, i * 2 + 2), 16);
      }
      return buffer;
    }
  }
  
  
  /**
   * Converts an array of bytes to a hexadecimal string.
   * 
   * @param data - Byte array.
   * @return - Hexadecimal string.
   */
  public String bytesToHex(byte[] data)
  {
    if (data == null)
    {
      return null;
    }
    else
    {
      int len = data.length;
      String str = "";
      for (int i = 0; i < len; i++)
      {
        if ((data[i] & 0xFF) < 16)
          str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
        else
          str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
      }
      return str.toUpperCase();
    }
  }


}

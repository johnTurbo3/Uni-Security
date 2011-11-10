package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
  public static void main(String[] argv)
  {
    long start = System.currentTimeMillis();
    Thread.currentThread().setPriority(9);
    Decrypter decrypter1 = new Decrypter("7237EF0835B25DAEAFB29F3E4C8C0F01",
        "E:/Dropbox/programming/windows/java/Test_Workspace/KeyProducer/output1.txt", 1);

    Decrypter decrypter2 = new Decrypter("97198a6c2f4ef217113a79daab778216ef552c6771b55a8e",
        "E:/Dropbox/programming/windows/java/Test_Workspace/KeyProducer/output2.txt", 2);
    
    Decrypter decrypter3 = new Decrypter("97198a6c2f4ef217113a79daab778216ef552c6771b55a8e",
        "E:/Dropbox/programming/windows/java/Test_Workspace/KeyProducer/output3.txt", 3);
    
    Decrypter decrypter4 = new Decrypter("97198a6c2f4ef217113a79daab778216ef552c6771b55a8e",
        "E:/Dropbox/programming/windows/java/Test_Workspace/KeyProducer/output4.txt", 4);
    
    ExecutorService threadExecutor = Executors.newCachedThreadPool();
    threadExecutor.execute(decrypter1);
    threadExecutor.execute(decrypter2);
    threadExecutor.execute(decrypter3);
    threadExecutor.execute(decrypter4);
    
    threadExecutor.shutdown();
    
    long end = System.currentTimeMillis();
    
    System.out.println(end-start);
  }
}
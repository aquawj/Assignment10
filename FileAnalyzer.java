package assignment10;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
   This class prints a report on the contents of a file.
*/
public class FileAnalyzer
{
   public static void main(String[] args) throws IOException
   {
      System.out.println("Filename: ");
      Scanner in = new Scanner(System.in);
      String name = in.nextLine();
      FileCounter counter = new FileCounter();
      FileReader reader = new FileReader(name);
      Scanner fileIn = new Scanner(reader);
      counter.read(fileIn);
      fileIn.close();
      System.out.println("Characters: " + counter.getCharacterCount());
      System.out.println("Words: " + counter.getWordCount());
      System.out.println("Lines : " + counter.getLineCount());
   }
}

/**
   A class to count the number of characters, words, and lines in files.
*/
class FileCounter
{
   /**
      Constructs a FileCounter object.
   */
   public FileCounter()
   {
      
   }

   /**
      Processes  an input source and adds its character, word, and line
      counts to this counter.
      @param in the scanner to process
   */
   public void read(Scanner in)
   {
	   String name=in.nextLine();
	   File file=new File(name);
	   FileInputStream fis=new FileInputStream(file);
	   int available =fis.available();
	   byte b[]=new byte[available];
	   fis.read(b);
	   fis.close();
   }

   /**
      Gets the number of words in this counter.
      @return the number of words
   */
   public int getWordCount()
   {
     String s=new String(b);
   }

   /**
      Gets the number of lines in this counter.
      @return the number of lines
   */
   public int getLineCount()
   {
. . .
   }

   /**
      Gets the number of characters in this counter.
      @return the number of characters
   */
   public int getCharacterCount()
   {
      . . .
   }
   . . .
}

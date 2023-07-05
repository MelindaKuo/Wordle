import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class WordData{

  String currentWord = "";
  ArrayList<String> words;
  
  public WordData() {
    words = new ArrayList<String>();
  }
  public String chooseWord() throws FileNotFoundException {
    Scanner fileScan = new Scanner(new File("words.txt"));
    int count=0;
    String word = "";
     
    while (fileScan.hasNext())
    {
       word = fileScan.nextLine();
       words.add(word);
    }
    System.out.println(words.size());
    int randomIndexNum = (int) (Math.random() * words.size());
   // fill in code to 
    // get random word from arraylist
    currentWord = words.get(randomIndexNum);
        /// delete that word from the arraylist
    words.remove(randomIndexNum);
    WriteWordsToFile();

    // call WriteWordsToFile
    // call write out to file 
      
    return (currentWord);
  }
public void WriteWordsToFile() {
   try{
    FileWriter fw = new FileWriter("words.txt", false);
     FileWriter fw2 = new FileWriter("usedWords.txt", true);
    PrintWriter pw = new PrintWriter(fw, false);   
      PrintWriter pw2 = new PrintWriter(fw2, false);   
    for (String w: words)
  { 
    pw.println(w);
  
  }
      pw2.println(currentWord);
  fw.flush();
  fw.close();
  fw2.close();
  pw.flush();
  pw.close();
  pw2.close();
  }catch(Exception exception){
      System.out.println("File exception have been caught");
  }
}
}
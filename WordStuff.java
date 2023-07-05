import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class WordStuff{
  private String currentReport;
  private String answer;
  private String currentGuess;
  private boolean [] guessedCorrectly;
  
  public WordStuff(String g, String answer){
    currentGuess = g;
    this.answer = answer;
    currentReport="";
    guessedCorrectly = new boolean[5];
   
  }
public String getCurrentReport(){
  return currentReport;
}
private boolean letterInOtherPlace(int j){
   for(int i =0; i<5; i++){
      if ((currentGuess.charAt(j) == answer.charAt(i)) && !guessedCorrectly[i]){
           return true;
      }
    
   }
   return false;
}


  public boolean checkWord(){
    
     currentReport="";
    if (currentGuess.equals(answer))
      return true;
    for(int i =0; i<5; i++){
      if(currentGuess.charAt(i) == answer.charAt(i)){
        currentReport+="*";
        guessedCorrectly[i] = true;
        
      }
      // if letter is in word but not at that index
      else
        { if (letterInOtherPlace(i))
            currentReport+="/";
          else
           currentReport+="-";
        }
        
    }
    return false;
  }

  public boolean inDictionary(String target)throws FileNotFoundException {
    Scanner fileScan = new Scanner(new File("dictionary.txt"));
    
    int count=0;
    String word = "";
  while (fileScan.hasNext())
    {fileScan.nextLine();
      count++;
    }
    fileScan.close();
    fileScan = new Scanner(new File("dictionary.txt"));
    
    
    String [] dictArray = new String[count];
     for(int i =0; i<dictArray.length; i++){
      dictArray[i]=fileScan.nextLine();
     }
    sort(dictArray);
    if (binarySearch(dictArray,target)>=0)
      return true;
   return false;
      //search the array using binary search
  }

  /**
   * Uses Binary Search to look for target in an array a, sorted in
   * ascending order.  If found, returns the index of the matching
   * element; otherwise returns -1.
   */
  public int binarySearch(String[] dict,String target){
    int left = 0, right = dict.length - 1;
    while (left <= right)
    {
      // Take the index of the middle element between
      //   "left" and "right":
      int middle = (left + right) / 2;
      // Compare this element to the target value
      // and adjust the search range accordingly:
      int diff = target.compareTo(dict[middle]);
      if (diff > 0)   // target > a [middle]
        left = middle + 1;
      else if (diff < 0)   // target < a[middle]
        right = middle - 1;
      else   // target is equal to a[middle]
	return middle;
	}
	return -1;
	}
  /*
Selection Sort
1. Initialize a variable n to the size of the array. 
2. Find the largest among the first n elements.
3. Make it swap places with the n-th element. 
4. Decrement n by 1.
5. Repeat steps2-4 while n ≥ 2.
  */
  
public void sort(String[] dictA)
  {
    // System.out.println("before sort");
    // for(int i =0; i<dictA.length; i++){
    //   System.out.print(dictA[i] + " ");
   
    int n = dictA.length;

    for(int i=0;i < n-1; i++){
        int min_idx = i;
       for(int j = i + 1;j < n; j++){
         // compareTo 0 if equal, neg number for < and pos num for >
         // lexigraphical order  apple Apply Ape
          if (dictA[j].compareTo(dictA[min_idx]) < 0 )
             min_idx = j;
       }
   
     String temp = dictA[min_idx];
     dictA[min_idx] = dictA[i];
     dictA[i] = temp;
       }

    // System.out.println("after sort");
    // for(int i =0; i<dictA.length; i++){
    //   System.out.print(dictA[i] + " ");

}
}

import java.util.Scanner;
import java.io.*;
class Main {
  public static void main(String[] args) throws FileNotFoundException { 
          
  String playAgain = "y";
   while (playAgain.equals("y"))
     {
        WordData wordleWord = new WordData();
        String chosenWord = wordleWord.chooseWord();
        System.out.println(chosenWord);
        
        int counter = 1;
        WordStuff myWord = null;
        Scanner sc = new Scanner(System.in);
        boolean wordMatch=false;
        while(!wordMatch  && counter <=6) {         
          System.out.println("Enter your guess");       
          String guess = sc.nextLine();
          if(guess.length() < 5 || guess.length() >5){
            System.out.println("Word has to be 5");
          }
          else{
    
            myWord = new WordStuff(guess,chosenWord);
           
            if (!myWord.inDictionary(guess))
               System.out.println("not in dictionary");
            else
            {
             System.out.println(myWord.getCurrentReport());
             if ( myWord.checkWord())
                    wordMatch = true;
            System.out.println(myWord.getCurrentReport());
            counter++;
            } // end else not in dict
        } // end else not 5 characters lon
        }// end while
         if(wordMatch){
           System.out.println("Good you guessed the word in " + (counter-1) + " tries");
         }
         else if(counter >= 6){
            System.out.println("You've used up 6 tries");
          }
            System.out.println("DO you want to play again");
            playAgain = sc.nextLine();
    }
  }
  
}

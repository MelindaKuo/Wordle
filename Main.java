/*The answer will have at most two sets of duplicate letters. Wordle only uses five-letter words, after all.

There are no five-letter words that use the same letter four times. They can only be sets of two or three.

If you try a word that shares duplicate letters with the answer, every instance of that letter will change color. For example, if you guess ”lever” and the answer is “eaten,” the first E in “lever” will turn yellow and the second one will turn green. The first one is in the word but in the wrong spot, and the second one is in the correct spot. The other letters will turn gray.

eaten
1 double letter e
1 triple letter

eiree
  
lever
-/-*-
  Eerie.
Emcee.
Error.
Fluff.
  


Keep in mind that Wordle tells you when a letter is not duplicated, too. If you use two of the same letter in a word, and only one of them turns yellow or green, then there is only one copy of that letter in the correct Wordle answer.
*/

  
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

// count how many errors (you guessed the word in .. )
// only 6 tries
// choose another word
// wordstuff to keep track of how many tries
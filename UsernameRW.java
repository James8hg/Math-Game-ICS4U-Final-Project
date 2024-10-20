//reads the usernames and outputs the results 
import java.io.*; 
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UsernameRW {
 public static Set<String> usernameSet = new HashSet<String>();
  //reads the username file and out puts the score to the graphical window
  public static void printUsername () {
    Main.wordsGuessedArea.setText("");
    for (String s: usernameSet){
      Main.wordsGuessedArea.append(s + "\n\n");
    }
    Main.wordsGuessedArea.setSelectionStart(0);
    Main.wordsGuessedArea.setSelectionEnd(0); //scroll the bar to the top
    Main.wordsGuessedLabel.setText("Player Scores");
  }  
  // prints the array of usernames and their scores to a text file
  public static void addUsername (String username, int correct, int incorrect) throws IOException {
    usernameSet.clear();
    Scanner scanner = new Scanner(new FileReader("username.txt")); //file reader
    int hello = 0;
    while (scanner.hasNextLine()) { //file reader for username
      
      String usernameScore = scanner.nextLine();
     usernameSet.add(usernameScore);
      
      System.out.println("test" + usernameSet);
      
     // System.out.println("test test " + usernameScore);
    /* boolean check = checkUsername(username, correct, incorrect, usernameScore);
      
      if (check == true) {
        hello = 1;
      }
      else if ( hello != 1) {
        usernameSet.add(username + " total correct: " + correct + " total incorrect: " + incorrect);
        hello = 1;
      } */
     // System.out.println("test test 3 " + usernameScore);
    }
    for (String s: usernameSet){
        System.out.println(s);
       boolean check = checkUsername(username, correct, incorrect, s);
      if (check == true) {
        //p.println(s);
        hello = 1;
        break;
      }
    }
    if (hello != 1) {
      usernameSet.add(username + " total correct: " + correct + " total incorrect: " + incorrect);
    }
    
    PrintWriter pw = new PrintWriter("username.txt");
    pw.close(); // clears the text from old file if it exisits
    try (FileWriter f = new FileWriter("username.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) { // allows to apend file
      // p.println(username + " total correct: " + correct + " total incorrect: " + incorrect);
      /*for (String s: usernameSet){
        System.out.println(s);
        checkUsername(username, correct, incorrect, s);
        //p.println(s);
      }*/
      for (String s: usernameSet){
        //checkUsername(username, correct, incorrect, s);
      p.println(s);
      }
      System.out.println(usernameSet);
      }
    catch (FileNotFoundException err) { // for file catch
      System.out.println("File name is innacurate ");
    }
  }

  //checks to make sure the user name does not already exist
  // If it does then it updates the string with the new score
  public static boolean checkUsername (String username, Integer correct, Integer incorrect, String usernameScore) {
    Pattern usernamePattern = Pattern.compile(username + " ");
    Matcher usernameMatcher = usernamePattern.matcher(usernameScore);
    
    if (usernameMatcher.find()) {
      usernameSet.remove(usernameScore);
      String[] parts = usernameScore.split("total incorrect");
      correct = correct + Integer.parseInt(parts[0].replaceAll("\\D+","")); // gets rid of all non digets and adds to tally
      incorrect = incorrect + Integer.parseInt(parts[1].replaceAll("\\D+",""));
      System.out.println("incorrect " + incorrect);
     usernameScore = (usernameScore.replaceAll("([0-9]* total incorrect: [0-9]*)", String.valueOf(correct)  + " total incorrect: " + incorrect));
       usernameSet.add(usernameScore);
      System.out.println(" usernameScore is " + usernameScore);
      
      //bob total correct: 1 total incorrect: 4
      return true;
    }
    else {
      //System.out.println(usernameScore);
   // usernameSet.add(username + " total correct: " + correct + " total incorrect: " + incorrect);
    //  System.out.println("this is a test" + usernameSet);
      return false;
    }  
  }
}
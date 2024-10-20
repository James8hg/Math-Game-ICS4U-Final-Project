// Code taken and then modifity from the common words assignment using binary search
import java.io.*; 
import java.util.Scanner;
public class JottoWordsClass {
  public static String[] jottoWordsArray = new String[12470];
  public static String[] jottoAnswersArray = new String[2309];
  public static void generateJottoWordsArray() throws IOException {
    try {
      File file = new File("jottoWords.txt");
      Scanner scanner = new Scanner(file);
      // Keeps track of the indices from 0 to 4999
      int index = 0;

      while (scanner.hasNext()) {
        // Adds each word to *commonWordsArray*
        jottoWordsArray[index] = scanner.next();
        index++;
      }
      
      // Closes the scanner for good housekeeping
      scanner.close();
    } catch (IOException exception) {
      System.out.println("Something is wrong with the file.");
    }
  }
   public static void generateAnswersArray() throws IOException {
    try {
      File file = new File("jottoAnswers.txt");
      Scanner scanner = new Scanner(file);
      // Keeps track of the indices from 0 to 4999
      int index = 0;

      while (scanner.hasNext()) {
        // Adds each word to *commonWordsArray*
        jottoAnswersArray[index] = scanner.next();
        index++;
      }
      
      // Closes the scanner for good housekeeping
      scanner.close();
    } catch (IOException exception) {
      System.out.println("Something is wrong with the file.");
    }
  }
  public static boolean isCommonWord(String word) {
    word = word.toLowerCase();
    double lower = 0;
    double higher = 12470;
    int count = 0;
    for (double i = Math.round((((( lower +  higher) / 2)) * 100.0) / 100.0); count <= 14; i = Math.round((((( lower +  higher) / 2)) * 100.0) / 100.0)) { 
      if (jottoWordsArray[(int) i].compareTo(word) < 0) {
        lower = ((lower + higher) / 2);
        }
      else if ((jottoWordsArray[(int) i].compareTo(word)) > 0) {
        higher = ((lower + higher) / 2);
      }
      else if (jottoWordsArray[(int) i].compareTo(word) == 0) {
        return true;
      }
      count++;
    }
    return false;
  }
}
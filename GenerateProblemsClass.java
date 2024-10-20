import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.awt.event.KeyEvent.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.io.*; 
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
// this class generates all of the problems that will be displayed to the user
public class GenerateProblemsClass extends Main {
  
  public GenerateProblemsClass() throws IOException{ 
  //explicit contructor to handle exception
    
    
}
   //Set<Integer> numberSet = new HashSet<Integer>();
   public static void generateAdditionProblems() {
     
     numberSet.clear();
     answer = JottoWordsClass.jottoAnswersArray[(int)((Math.random() * 2308) + 1)];
      boolean sameLetters;
     do{
        sameLetters = false;
       for(int i = 0; i < 4; i++) {
         for(int j = i+1; j < 5; j++) {
           if (answer.charAt(i) == answer.charAt(j)){
           sameLetters = true;
             System.out.println("same letter");
             answer = JottoWordsClass.jottoAnswersArray[(int)((Math.random() * 2308) + 1)];
           }
         }
        } 
      }
      while (sameLetters == true); 
     System.out.println(answer);
     wordsGuessedArea.setText("");
    int num1 = numberGenerator(100);
    int num2 = numberGenerator(100);
    int num3 = numberGenerator(100);
    int questionMark = num1 + num2;
    int star = questionMark + num2;
    int hashtag = questionMark + star;
    int exclamationMark = questionMark + hashtag;
    int and = questionMark - num3;
     
    String questionMarkLetter = answer.charAt(0) + " - " + Integer.toString(questionMark);
     String starLetter = answer.charAt(1) + " - " + Integer.toString(star);
     String hashtagLetter = answer.charAt(2) + " - " + Integer.toString(hashtag);
     String exclamationMarkLetter = answer.charAt(3) + " - " + Integer.toString(exclamationMark);
     String andLetter = answer.charAt(4) + " - " + Integer.toString(and);
    String letterNums = "\n";
    for(char i = 'a'; i <= 'z'; i++){
      if(i != answer.charAt(0) && i != answer.charAt(1) && i != answer.charAt(2) && i != answer.charAt(3) && i != answer.charAt(4)) {
        letterNums = letterNums + " " + i + " - " + Integer.toString(numberGenerator(100)) + "\n";
      }
      else if(answer.charAt(0) == i) {
        letterNums = letterNums + " " + questionMarkLetter + "\n";
      }
      else if(answer.charAt(1) == i) {
        letterNums = letterNums + " " + starLetter + "\n";
      }
      else if(answer.charAt(2) == i) {
        letterNums = letterNums + " " + hashtagLetter +  "\n";
      }
      else if(answer.charAt(3) == i) {
        letterNums = letterNums + " " + exclamationMarkLetter + "\n";
      }
      else if(answer.charAt(4) == i) {
        letterNums = letterNums + " " + andLetter +  "\n";
      }
    }
  
     
    wordsGuessedArea.append(num1 + " + " + num2 + " = ?\n" );
   wordsGuessedArea.append("? + " + num2 + " = * \n" ); 
    wordsGuessedArea.append("? + * = # \n" ); 
    wordsGuessedArea.append("! = ? + # \n" );
    wordsGuessedArea.append("? - " + num3 + " = & \n" );
    //wordsGuessedArea.append(questionMarkLetter + "A-1 B-2 C-3 D-4 E-5 F-6 G-7 H-8 I-9 J-10 K-11 L-12 M-13 N-14 O-15 P-16 Q-17 R-18 S-19 T-20 U-21 V-22 W-23 X-24 Y-25 Z-26");
     wordsGuessedArea.append(letterNums);
    wordsGuessedArea.setSelectionStart(0);
    wordsGuessedArea.setSelectionEnd(0);   
   }
  // needs fixing
  public static void generateMultiplicationProblems() {
    numberSet.clear();
    answer = JottoWordsClass.jottoAnswersArray[(int)((Math.random() * 2308) + 1)];
    sameLetters();//makes sure word does not have duplicate letters 
    System.out.println(answer);
    wordsGuessedArea.setText("");
    int num1 = numberGenerator(10);
    int num2 = numberGenerator(10);
    int num3 = numberGenerator(10) * 12;
    int num4 = numberGenerator(10);
    System.out.println("num1 " + num1 + " num2 " + num2 + " num3 " + num3 + " num4 " + num4);
    int questionMark = num1 * num2;
    int star = num3 * num2;
    int hashtag = questionMark * num1;
    int exclamationMark = hashtag / num2;
    int and = (questionMark * num4) / questionMark;
    
    numberSet.add(questionMark);
    numberSet.add(star);
    numberSet.add(hashtag);
    numberSet.add(exclamationMark);
    numberSet.add(and); // so the anwser number are only for one letter
     
    String questionMarkLetter = answer.charAt(0) + " - " + Integer.toString(questionMark);
    String starLetter = answer.charAt(1) + " - " + Integer.toString(star);
    String hashtagLetter = answer.charAt(2) + " - " + Integer.toString(hashtag);
    String exclamationMarkLetter = answer.charAt(3) + " - " + Integer.toString(exclamationMark);
    String andLetter = answer.charAt(4) + " - " + Integer.toString(and);
    String letterNums = "\n";
    for(char i = 'a'; i <= 'z'; i++){
      if(i != answer.charAt(0) && i != answer.charAt(1) && i != answer.charAt(2) && i != answer.charAt(3) && i != answer.charAt(4)) {
        letterNums = letterNums + " " + i + " - " + Integer.toString(numberGenerator(50)) + "\n";
      }
      else if(answer.charAt(0) == i) {
        letterNums = letterNums + " " + questionMarkLetter + "\n";
      }
      else if(answer.charAt(1) == i) {
        letterNums = letterNums + " " + starLetter + "\n";
      }
      else if(answer.charAt(2) == i) {
        letterNums = letterNums + " " + hashtagLetter +  "\n";
      }
      else if(answer.charAt(3) == i) {
        letterNums = letterNums + " " + exclamationMarkLetter + "\n";
      }
      else if(answer.charAt(4) == i) {
        letterNums = letterNums + " " + andLetter +  "\n";
      }
    }
    
    wordsGuessedArea.append(num1 + " x " + num2 + " = ?\n" );
    wordsGuessedArea.append(num3 + " x " + num2 + " = * \n" ); 
    wordsGuessedArea.append("? x " +  num1 + " = # \n" ); 
    wordsGuessedArea.append("! = # / " + num2 + "\n" );
    wordsGuessedArea.append(questionMark * num4 + " / ? = & \n" );
    
    wordsGuessedArea.append(letterNums);
    wordsGuessedArea.setSelectionStart(0);
    wordsGuessedArea.setSelectionEnd(0);   
   }
  public static int numberGenerator (int range) {
    //numberSet.add(0); //adds 0 so there is no divide by zero error
    int num = (int) (Math.random() *(range)) + 1;
    int oldSize = numberSet.size();
    numberSet.add(num);
    if (numberSet.size() == oldSize) {
      System.out.println("there was a duplicate" + num);
      numberGenerator(range);
    }
    
      return num;   
    
  }
  public static void sameLetters(){
    boolean sameLetters;
    do{
    sameLetters = false;
      for(int i = 0; i < 4; i++) {
        for(int j = i+1; j < 5; j++) {
          if (answer.charAt(i) == answer.charAt(j)){
            sameLetters = true;
            System.out.println("same letter");
            answer = JottoWordsClass.jottoAnswersArray[(int)((Math.random() * 2308) + 1)];
          }
        }
      } 
    }
    while (sameLetters == true); 
  }
}
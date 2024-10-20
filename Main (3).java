/**
 * @GohlJames
 */

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

public class Main extends JFrame {
  public static JFrame frame = new JFrame("ArithmaCode!");
  public static JLabel wordsGuessedLabel = new JLabel("Math Problems:");
  JLabel nextGuessLabel = new JLabel("Guess Word:");
  JLabel validWordLabel = new JLabel();
  public static JTextArea wordsGuessedArea = new JTextArea();
  JLabel guessesSoFarLabel = new JLabel("<html>The word: ? * # ! &<html>");
  JLabel theWordIsLabel = new JLabel("<html> The word: ? * # ! &<br>Use the text boxes above to keep track of the values of the special symbols if you would like.<html>");
  JLabel questionMarkLabel = new JLabel("?");
  JLabel starLabel = new JLabel("*");
  JLabel hashtagLabel = new JLabel("#");
  JLabel exclamationMarkLabel = new JLabel("!");
  JLabel andLabel = new JLabel("&");
  JLabel enterName = new JLabel("Enter Name:");
  
  JTextField nextGuessField = new JTextField();
  JTextField questionMarkField = new JTextField();
  JTextField starField = new JTextField();
  JTextField hashtagField = new JTextField();
  JTextField exclamationMarkField = new JTextField();
  JTextField andField = new JTextField();
  JButton guessWordButton = new JButton("Guess Word");
  JButton giveUpButton = new JButton("Give Up");
  JButton playAgainButton = new JButton("Play Again");
  JScrollPane wordsGuessedScroller = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  // The panel that has the instructions
  JPanel panel = new JPanel();
  JButton nameButton = new JButton("Submit Name");
  JButton additionButton = new JButton("addition");
  JButton multiplicationButton = new JButton("multiplication");
  JButton additionButtonGame = new JButton("addition");
  JButton multiplicationButtonGame = new JButton("game multiplication");
  final Color DARK_GREEN = new Color(58, 86, 34);
  
  public static String answer;
  static Set<Integer> numberSet = new HashSet<Integer>();
  public String username;
  public boolean additionBool;

  public Main() throws IOException{
    JottoWordsClass.generateAnswersArray();
    setInstructionsPanel();
    
    this.add(panel);
    this.setSize(800, 600);
    this.setResizable(false);
    this.setTitle("ArithmaCode!");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  
    }

    // sets the pannels with the instructions
    // @return void
    private void setInstructionsPanel(){
    panel.setLayout(null);
    panel.removeAll();
    
    // The "Next" button
    JButton nextButton = new JButton();
    nextButton.setText("NEXT");
    nextButton.setSize(100, 50);
    nextButton.setLocation(350, 515);
    nextButton.setForeground(DARK_GREEN);
    nextButton.setBackground(Color.WHITE);
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        setExamplePanel(evt);
      }
    });
    
    // The title
    JLabel instructionsTitle = new JLabel("How to Play ArithmaCode!");
    
    instructionsTitle.setSize(736, 100);
    instructionsTitle.setLocation(200, 0);
    instructionsTitle.setFont(new Font("Helvetica", Font.PLAIN, 36));
    instructionsTitle.setForeground(Color.WHITE);
    
    // The instructions
    JLabel instructions1 = new JLabel();
    JTextArea instructions2 = new JTextArea();
    JLabel instructions3 = new JLabel();
    JTextArea instructions4 = new JTextArea();
    instructions4.setLineWrap(true);
    instructions4.setWrapStyleWord(true);
    
    instructions1.setText("How to win:");
    instructions2.setText("Guess the secret code by anwsering a series of questions");
    instructions3.setText("How to play:");
    instructions4.setText("Start by enetering your name. Then click multiplication if you want to do mulitplication question and addition if you want addition. Answer question 1 to figure out the value of the unkown varriable. Use that varriable to solve the next question.Then use the next varriable to solve the next question and so on, until you have solved all the questions. Use the letter and the symbols number to find the secret word. Enter the secret word into the box. The game will tell you if the word is correct or not. When you click play again it will display questions of the box that is green. Click the box of multiplication or addition if you want to change the type then click play again.");
    
    instructions1.setSize(736, 50);
    instructions1.setLocation(25, 70);
    instructions1.setBackground(DARK_GREEN);
    instructions1.setFont(new Font("Helvetica", Font.PLAIN, 25));
    instructions1.setForeground(Color.WHITE);
    
    instructions2.setSize(736, 30);
    instructions2.setLocation(25, 120);
    instructions2.setBackground(DARK_GREEN);
    instructions2.setFont(new Font("Helvetica", Font.PLAIN, 20));
    instructions2.setForeground(Color.WHITE);
    instructions2.setEditable(false);
    
    instructions3.setSize(736, 50);
    instructions3.setLocation(25, 150);
    instructions3.setBackground(DARK_GREEN);      
    instructions3.setFont(new Font("Helvetica", Font.PLAIN, 25));
    instructions3.setForeground(Color.WHITE);
    
    instructions4.setSize(736, 300);
    instructions4.setLocation(25, 200);
    instructions4.setBackground(DARK_GREEN);
    instructions4.setFont(new Font("Helvetica", Font.PLAIN, 20));
    instructions4.setForeground(Color.WHITE);
    instructions4.setEditable(false);
    
    // The background is dark green
    panel.setBackground(DARK_GREEN);
      
    // Adds the components to the panel
    panel.add(nextButton);
    panel.add(instructionsTitle);
    panel.add(instructions1);
    panel.add(instructions2);
    panel.add(instructions3);
    panel.add(instructions4);
    panel.updateUI();
    this.add(panel);
  }

    //Sets the pannel that has all the examples
    // @param return void
    private void setExamplePanel(ActionEvent evt) {
    panel.removeAll();
    panel.setBackground(DARK_GREEN);
    
    // The title
    JLabel instructionsTitle = new JLabel("How to Play ArithmaCode!");
    instructionsTitle.setSize(736, 100);
    instructionsTitle.setLocation(200, 0);
    instructionsTitle.setFont(new Font("Helvetica", Font.PLAIN, 40));
    instructionsTitle.setForeground(Color.WHITE);
    
    // The word "Example"
    JLabel instructions1 = new JLabel();
    instructions1.setText("Example:");
    instructions1.setSize(736, 50);
    instructions1.setLocation(25, 100);
    instructions1.setBackground(DARK_GREEN);
    instructions1.setFont(new Font("Helvetica", Font.PLAIN, 30));
    instructions1.setForeground(Color.WHITE);
    
    // The word "Before"
    JLabel instructions2 = new JLabel();
    instructions2.setText("Before");
    instructions2.setSize(736, 56);
    instructions2.setLocation(152, 165);
    instructions2.setBackground(DARK_GREEN);
    instructions2.setFont(new Font("Helvetica", Font.PLAIN, 30));
    instructions2.setForeground(Color.WHITE);
    
    // The word "After"
    JLabel instructions3 = new JLabel();
    instructions3.setText("After");
    instructions3.setSize(736, 56);
    instructions3.setLocation(565, 165);
    instructions3.setBackground(DARK_GREEN);
    instructions3.setFont(new Font("Helvetica", Font.PLAIN, 30));
    instructions3.setForeground(Color.WHITE);
    
    // The image showing the example of the game
    JLabel exampleLabel = new JLabel();
    exampleLabel.setSize(688, 285);
    exampleLabel.setLocation(56, 215);
    exampleLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("example.png")).getImage().getScaledInstance(688, 285, Image.SCALE_SMOOTH))); //scales the image so it does not get cropped so you can see everything
    
    // The "Back" button
    JButton backButton = new JButton();
    backButton.setText("BACK");
    backButton.setSize(100, 50);
    backButton.setLocation(280, 515);
    backButton.setForeground(DARK_GREEN);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        backButtonPressed(evt);
      }
    });
    
    // The "Start" button
    JButton startButton = new JButton();
    startButton.setText("START");
    startButton.setSize(100, 50);
    startButton.setLocation(420, 515);
    startButton.setForeground(DARK_GREEN);
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {  
        startButtonPressed (evt);
      }
    });
    
    // Ads all the labels to the panel
    panel.add(instructionsTitle);
    panel.add(instructions1);
    panel.add(instructions2);
    panel.add(instructions3);
    panel.add(exampleLabel);
    panel.add(backButton);
    panel.add(startButton);
    panel.updateUI();
    this.add(panel);
  }

  //Displays the pannel where the user inputs therir usenrame\
  //@ param return void
  private void askName(){
    panel.removeAll();
    frame.setSize(800, 800);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // The "Enter Name" label
    enterName.setBounds(400, 0, 200, 50);
    enterName.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(enterName);

    // The text field below "Enter Namer" that 
    // allows the user to entr name
    nextGuessField.setBounds(400, 50, 150, 50);
    nextGuessField.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(nextGuessField);
    nextGuessField.requestFocusInWindow(); 
    nextGuessField.requestFocus(); 

    //The button where the user descides to have addition problems or multilication problems
    additionButton.setBackground(new Color(0, 122, 225));
    additionButton.setForeground(Color.WHITE);
    additionButton.setBounds(400, 225, 150, 100);
    additionButton.setFont(new Font("Dialog", Font.PLAIN, 18));
    frame.add(additionButton);
    additionButton.setEnabled(false); //becomes true once user enters name

    multiplicationButton.setBackground(new Color(0, 122, 225));
    multiplicationButton.setForeground(Color.WHITE);
    multiplicationButton.setBounds(600, 225, 150, 100);
    multiplicationButton.setFont(new Font("Dialog", Font.PLAIN, 18));
    frame.add(multiplicationButton);
    multiplicationButton.setEnabled(false);
    
    // The "Submit name" button
    nameButton.setBackground(new Color(0, 122, 225));
    nameButton.setForeground(Color.WHITE);
    nameButton.setBounds(400, 125, 150, 50);
    nameButton.setFont(new Font("Dialog", Font.PLAIN, 18));
    nameButton.setText("guess name");
    nameButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        try {
        nameButtonPressed (evt);
          }
        catch (IOException e) { // for file catch
          System.out.println("File name is innacurate ");
        }
      }
    });
    frame.add(nameButton);
   
  }

  //sets the jframe that has the entire game on it
  //@param return void
  private void setGamePanel() {
    frame.getContentPane().removeAll();
    frame.repaint(); // tells window manager componets need to be redrawn
    frame.setSize(800, 800);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // The "Math problems" label
    wordsGuessedLabel.setBounds(50, 0, 200, 50);
    wordsGuessedLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(wordsGuessedLabel);

    // The "Next Guess" label
    nextGuessLabel.setBounds(400, 0, 200, 50);
    nextGuessLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(nextGuessLabel);

    // The label that displays:
    //  * "__ is not a valid word." 
    //  * "You've already guessed __".
    validWordLabel.setBounds(400, 175, 200, 100);
    validWordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(validWordLabel);

    // The label that dispays:
    // How the word is laid out
    theWordIsLabel.setBounds(50, 350, 300, 300);
    theWordIsLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(theWordIsLabel);

    // The label that displays:
    //  *you won"
    guessesSoFarLabel.setBounds(400, 250, 200, 100);
    guessesSoFarLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(guessesSoFarLabel);

    // The text area below "Math Problems" that 
    // displays the math problems and 
    // letters with numbers
    wordsGuessedArea.setBounds(50, 50, 300, 250);
    wordsGuessedArea.setFont(new Font("Dialog", Font.PLAIN, 20));
    wordsGuessedArea.setEditable(false);
    wordsGuessedScroller.setBounds(50, 50, 300, 250);
    wordsGuessedScroller.setViewportView(wordsGuessedArea);
    wordsGuessedArea.setLineWrap(true);
    frame.add(wordsGuessedScroller);


    // The text field below "Next Guess" that 
    // allows the user to guess words
    nextGuessField.setBounds(400, 50, 150, 50);
    nextGuessField.setFont(new Font("Dialog", Font.PLAIN, 20));
    nextGuessField.setText("");
    frame.add(nextGuessField);
    nextGuessField.requestFocusInWindow(); 
    nextGuessField.requestFocus(); 

    //Text fields and labels so user can keep track of the symbols values
    questionMarkField.setBounds(50, 350, 50, 50);
    questionMarkField.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(questionMarkField);
    questionMarkField.requestFocusInWindow(); 
    questionMarkField.requestFocus(); 
    
    questionMarkLabel.setBounds(75, 300, 50, 50);
    questionMarkLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(questionMarkLabel);

    starField.setBounds(125, 350, 50, 50);
    starField.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(starField);
    starField.requestFocusInWindow(); 
    starField.requestFocus(); 

    starLabel.setBounds(150, 300, 50, 50);
    starLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(starLabel);

    hashtagField.setBounds(200, 350, 50, 50);
    hashtagField.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(hashtagField);
    hashtagField.requestFocusInWindow(); 
    hashtagField.requestFocus(); 

    hashtagLabel.setBounds(225, 300, 50, 50);
    hashtagLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(hashtagLabel);

    
    exclamationMarkField.setBounds(275, 350, 50, 50);
    exclamationMarkField.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(exclamationMarkField);
    exclamationMarkField.requestFocusInWindow(); 
    exclamationMarkField.requestFocus(); 

    exclamationMarkLabel.setBounds(300, 300, 50, 50);
    exclamationMarkLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(exclamationMarkLabel);

    andField.setBounds(350, 350, 50, 50);
    andField.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(andField);
    andField.requestFocusInWindow(); 
    andField.requestFocus(); 

    andLabel.setBounds(350, 300, 50, 50);
    andLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
    frame.add(andLabel);

    //The buttons that changes the types of problems when user clicks play again
    if (additionBool == false) {
      multiplicationButtonGame.setBackground(Color.green);
    }
    else {
      multiplicationButtonGame.setBackground(new Color(0, 122, 225));
    }
    multiplicationButtonGame.setForeground(Color.WHITE);
    multiplicationButtonGame.setFont(new Font("Dialog", Font.PLAIN, 18));
    multiplicationButtonGame.setBounds(575, 325, 150, 100);
    multiplicationButtonGame.setVisible(true);
    multiplicationButtonGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          additionBool = false;  
          multiplicationButtonGame.setBackground(Color.green);
          additionButtonGame.setBackground(new Color(0, 122, 225));
      }
    });
    frame.add(multiplicationButtonGame);

    if (additionBool == true) {
      additionButtonGame.setBackground(Color.green);
    }
    else {
      additionButtonGame.setBackground(new Color(0, 122, 225));
    }
    additionButtonGame.setForeground(Color.WHITE);
    additionButtonGame.setFont(new Font("Dialog", Font.PLAIN, 18));
    additionButtonGame.setBounds(575, 450, 150, 100);
    additionButtonGame.setVisible(true);
    additionButtonGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          additionBool = true; 
          additionButtonGame.setBackground(Color.green);
          multiplicationButtonGame.setBackground(new Color(0, 122, 225));
        
      }
    });
    frame.add(additionButtonGame);
    
    
    // The "Submit answer" button
    guessWordButton.setBackground(new Color(0, 122, 225));
    guessWordButton.setForeground(Color.WHITE);
    guessWordButton.setBounds(400, 125, 150, 50);
    guessWordButton.setFont(new Font("Dialog", Font.PLAIN, 18));
    guessWordButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          guessWordMethod(); 
        }
        catch (IOException ev) { // for file catch
          System.out.println("File name is innacurate ");
        } 
      }
    });
    frame.add(guessWordButton);
    
    // declare the listener witch allows the enter key to be same as guessword button
    nextGuessField.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) {
        // VK_Enter is the key code for the ENTER key
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          try {
           guessWordMethod(); // same as guess word button
          }
          catch (IOException e) { // for file catch
            System.out.println("File name is innacurate ");
          } 
        }
      }
    });

    // The "Give Up" button
    giveUpButton.setBounds(400, 425, 150, 50);
    giveUpButton.setFont(new Font("Dialog", Font.PLAIN, 18));
    giveUpButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        guessesSoFarLabel.setBounds(375, 200, 200, 100);
        guessesSoFarLabel.setText("<html>The secret word was <br>\"<html>" + answer + "\"."); //the html allows a new line to be made so it can show up on the screen
        guessWordButton.setEnabled(false); // disables guess word button so they can't keep guessing after giving up
        nextGuessField.setEnabled(false);
        nextGuessField.setText("");
        UsernameRW.printUsername(); //outpus usernames and scores to the jframe
      }
    });
    // Adds button to frame
    frame.add(giveUpButton);

    // The "Play Again" button
    playAgainButton.setBounds(400, 500, 150, 50);
    playAgainButton.setFont(new Font(playAgainButton.getFont().getName(), Font.PLAIN, 18));
    playAgainButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        guessWordButton.setEnabled(true);
        giveUpButton.setEnabled(true);
        nextGuessField.setEnabled(true);
        nextGuessField.setText("");
        questionMarkField.setText("");
        starField.setText("");
        hashtagField.setText("");
        exclamationMarkField.setText("");
        andField.setText("");
        if (additionBool == true) {
          GenerateProblemsClass.generateAdditionProblems();
        }  
        else {
          GenerateProblemsClass.generateMultiplicationProblems();
        }
      }
    });
    frame.add(playAgainButton);
    

  }
    
  /**
   * Creates a new game.*/
   
    
  
  /**
   * The action listener for the "Back" button.
   * @param evt
   */
  private void backButtonPressed(ActionEvent evt) {
    setInstructionsPanel();
  }
  /**
   * The action listener for the "start" button.
   * @param evt
   */
  private void startButtonPressed(ActionEvent evt) /*throws IOException*/ {
    askName();
  }
  /**
   * The action listener for the "name" button.
   * @param evt
   */
  private void nameButtonPressed(ActionEvent evt) throws IOException {
    username = nextGuessField.getText();
    UsernameRW.addUsername(username, 0, 0);
    nameButton.setVisible(false);
    
    additionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {       
        try {
        additionButtonPressed (evt);
          }
        catch (IOException e) { // for file catch
      System.out.println("File name is innacurate ");
    }
      }
    });
    additionButton.setEnabled(true);
    
    multiplicationButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        try {
        multiplicationButtonPressed (evt);
          }
        catch (IOException e) { // for file catch
      System.out.println("File name is innacurate ");
    }
      }
    });
    multiplicationButton.setEnabled(true);
    
  
  }
  /**
   * The action listener for the "addition" button.
   *  Method displays the addition problems
   * @param evt
   */
  private void additionButtonPressed(ActionEvent evt) throws IOException {
    additionBool = true;
    setGamePanel();
    GenerateProblemsClass.generateAdditionProblems();
  }
  /**
     * The action listener for the "addition" button.
     *  Method displays the multiplicaion problems
     * @param evt
     */
  private void multiplicationButtonPressed(ActionEvent evt) throws IOException {
    additionBool = false;
    setGamePanel();
    GenerateProblemsClass.generateMultiplicationProblems();
    }

  //Method for when the user presses guess word or the enter button
  // @param return void
  private void guessWordMethod () throws IOException{
    String guess;
    validWordLabel.setText("");
    guess = nextGuessField.getText();
    guess = guess.toLowerCase(); //in case user uses uppercase
    if (guess.equals(answer)) {
      guessesSoFarLabel.setBounds(375, 200, 200, 100);
      guessesSoFarLabel.setText("<html>Congrats you won! You are very smart. The word was " + answer + ".<html>");
      guessWordButton.setEnabled(false); //disables guess word button so they cant guess more
      giveUpButton.setEnabled(false);
      nextGuessField.setEnabled(false);
      nextGuessField.setText("");
      UsernameRW.addUsername(username, 1, 0); //adds 1 to user score for correctly guessing word
      UsernameRW.printUsername(); //outputs all the users and there scores to the jframe
    }
    else {
      guessesSoFarLabel.setBounds(375, 200, 200, 100);
      guessesSoFarLabel.setText("<html>The word " + guess + " is invalid. You must have done a wrong calculation. <html>");
      nextGuessField.setText("");
      UsernameRW.addUsername(username, 0, 1); //adds one to the number of incorrect guesses to the users score
    }
    
  }

  /**
   * Creates the GUI.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    Main main = new Main();
  }
}

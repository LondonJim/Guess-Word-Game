package guess;

import java.io.IOException;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuessGame {

  private ScrapeRandomWord scrapeRandomWord;
  private Check check;
  private char guessChar;
  private String randomWord;
  private String randomWordMeaning;
  private JFrame frame;
  private KeyListener keyListener;

  public static void main(String[] args) throws IOException {
    GuessGame guessGame = new GuessGame();
  }

  public GuessGame() throws IOException {
    newGame();
  }

  public void newGame() throws IOException {
    this.scrapeRandomWord = new ScrapeRandomWord();
    getConvertWord();
    frame = new JFrame("Word Game");
    displayGame();
  }

  public GuessGame(ScrapeRandomWord scrapeRandomWord) throws IOException {
    this.scrapeRandomWord = scrapeRandomWord;
    getConvertWord();
  }

  private void displayGame() throws IOException {
    frame.setSize(400, 400);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    Container container = frame.getContentPane();
    container.setLayout(new BorderLayout());
    container.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);

    JLabel displayWord = new JLabel();
    JLabel displayLower = new JLabel();
    JLabel displayCenter = new JLabel();

    displayWord.setFont(new Font("Courier", Font.BOLD,40));
    displayWord.setHorizontalAlignment(JLabel.CENTER);
    displayWord.setText(check.initialDisplayWord());

    displayLower.setFont(new Font("Courier", Font.BOLD,20));
    displayLower.setHorizontalAlignment(JLabel.CENTER);
    displayLower.setText("Wrong Guesses: " + check.getWrongGuesses());

    displayCenter.setFont(new Font("Courier", Font.BOLD,40));
    displayCenter.setHorizontalAlignment(JLabel.CENTER);
    displayCenter.setText("Enter Letter");

    JButton button = new JButton("Restart");
    button.setFont(new Font("Courier", Font.BOLD,20));

    keyListener = new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        c = Character.toLowerCase(c);
        displayWord.setText(check.checkWord(c));
        if (check.verifyWordToGuesses()) {
          displayCenter.setFont(new Font("Courier", Font.BOLD,20));
          displayCenter.setText("<html><div style='text-align: center;'>"
            + randomWordMeaning + "<br/><br/>" + "Total Wrong Guesses: "
            + check.getWrongGuesses() + "</html>");
          displayLower.setText("");
          removeListener();
          container.add(button, BorderLayout.PAGE_END);
        } else {
          displayCenter.setFont(new Font("Courier", Font.BOLD,140));
          displayCenter.setText(Character.toString(c));
          displayLower.setText("<html><div style='text-align: center;'>"
            + check.getGuesses() + "<br/>Wrong Guesses: "
            + check.getWrongGuesses() + "</html>");
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
    };

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          frame.dispose();
          newGame();
        } catch (IOException error){
          error.printStackTrace();
        }
      }
    });

    container.add(displayWord, BorderLayout.PAGE_START);
    container.add(displayLower, BorderLayout.PAGE_END);
    container.add(displayCenter, BorderLayout.CENTER);
    frame.addKeyListener(keyListener);
    frame.setVisible(true);
  }

  private void getConvertWord() {
    scrapeRandomWord.execute();
    randomWordMeaning = scrapeRandomWord.getRandomWordMeaning();
    randomWord = scrapeRandomWord.getRandomWord();
    check = new Check(randomWord);
  }

  private void removeListener() {
    frame.removeKeyListener(keyListener);
  }

}

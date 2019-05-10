package guess;

import java.util.ArrayList;

public class Check {

  private String word;
  private String guesses;
  private char[] wordChars;
  private char[] arrayGuesses;

  public Check(String randomWord) {
    this.word = randomWord.toLowerCase();
  }

  public void checkWord(char guess) {
    convertWord();
    guessChars(guess);
  }

  public char[] convertWord() {
    wordChars = word.toCharArray();
    return wordChars;
  }

  public char[] guessChars(char guess) {
    if (guesses == null) {
      guesses = Character.toString(guess);
    } else {
      guesses += guess;
    }
    arrayGuesses = guesses.toCharArray();
    return arrayGuesses;
  }

}

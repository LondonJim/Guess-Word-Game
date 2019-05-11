package guess;

import java.util.ArrayList;
import java.util.Arrays;

public class Check {

  private String word = "";
  private String displayWord = "";
  private String guesses;
  private char[] wordChars;
  private char[] arrayGuesses = {' '};
  private char[] displayWordArray;

  public Check(String randomWord) {
    this.word = randomWord.toLowerCase();
    convertWord();
  }

  public String checkWord(char guessChar) {
    guessChars(guessChar);
    return displayWord();
  }

  public char[] convertWord() {
    wordChars = word.toCharArray();
    displayWordArray = new char[wordChars.length];
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

  public String displayWord() {
    displayWord = "";
    for (int i = 0; i < wordChars.length; i++) {
      for (int j = 0; j < arrayGuesses.length; j++) {
        if (wordChars[i] == arrayGuesses[j]) {
          displayWordArray[i] = wordChars[i];
        } else {
          if (displayWordArray[i] == 0) {
            displayWordArray[i] = '*';
          }
        }
      }
    }
    displayWord = new String(displayWordArray);

    return displayWord;
  }

  public boolean verifyWordToGuesses() {
    return (displayWord.equals(word));
  }

}

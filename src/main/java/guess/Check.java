package guess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Check {

  private String word = "";
  private String displayWord = "";
  private String guesses;
  private char currentGuess;
  private boolean addWrongGuess;
  private int wrongGuesses = 0;
  private char[] wordChars;
  private char[] arrayGuesses;
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

  public char[] guessChars(char guessChar) {
    if (guesses == null) {
      currentGuess = guessChar;
      guesses = Character.toString(currentGuess);
      arrayGuesses = guesses.toCharArray();
    } else if ((guesses.indexOf(guessChar) == -1)) {
      currentGuess = guessChar;
      guesses += currentGuess;
      arrayGuesses = guesses.toCharArray();
    }
    return arrayGuesses;
  }

  public String displayWord() {
    addWrongGuess = true;
    displayWord = "";
    for (int i = 0; i < wordChars.length; i++) {
      for (int j = 0; j < arrayGuesses.length; j++) {
        if (wordChars[i] == arrayGuesses[j]) {
          if (arrayGuesses[j] == currentGuess) {
            addWrongGuess = false;
          }
          displayWordArray[i] = wordChars[i];
        } else {
          if (displayWordArray[i] == 0) {
            displayWordArray[i] = '*';
          }
        }
      }
    }

    if (addWrongGuess) {
      wrongGuesses += 1;
    }
    displayWord = new String(displayWordArray);

    return displayWord;
  }

  public boolean verifyWordToGuesses() {
    return (displayWord.equals(word));
  }

  public String initialDisplayWord() {
    String str = "*";
    return str.repeat(word.length());
  }

  public int getWrongGuesses() {
    return wrongGuesses;
  }

  public String getGuesses() {
    Arrays.sort(arrayGuesses);
    return new String(arrayGuesses);
  }
}

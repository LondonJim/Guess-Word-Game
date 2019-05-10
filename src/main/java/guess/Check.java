package guess;

import java.util.ArrayList;

public class Check {

  private String word;
  private String displayWord;
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

  public String displayWord() {
    displayWord = "";
    for (int i = 0; i < wordChars.length; i++) {
      for (int j = 0; j < arrayGuesses.length; j++) {
        if (wordChars[i] == arrayGuesses[j]) {
          displayWord += wordChars[i];
        } else {
          displayWord += "*";
        }
      }
    }
    return displayWord;
  }

}

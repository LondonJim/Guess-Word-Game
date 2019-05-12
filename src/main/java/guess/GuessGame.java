package guess;

import java.io.IOException;

public class GuessGame {

  private GetRandomWord getRandomWord;
  private Check check;
  private char guessChar;
  private char ignoreChar;
  private String randomWord;

  public static void main(String[] args) throws IOException{
    GuessGame guessGame = new GuessGame();
    guessGame.play();
  }

  public GuessGame() throws IOException{
    this.getRandomWord = new GetRandomWord();
    getConvertWord();
  }

  public GuessGame(GetRandomWord getRandomWord) throws IOException{
    this.getRandomWord = getRandomWord;
    getConvertWord();
  }

  private void getConvertWord() {
    randomWord = getRandomWord.getWord();
    check = new Check(randomWord);
  }

  private void play() throws IOException {
    System.out.println(check.initialDisplayWord());
    gameLoop();
    System.out.println("You win");
  }

  private void gameLoop() throws IOException{
    while (!check.verifyWordToGuesses()) {
      displayConsole();
    }
  }

  private void displayConsole() throws IOException {
    System.out.print("Enter Letter Guess: ");
    guessChar = (char) System.in.read();
    do {
      ignoreChar = (char) System.in.read();
    } while (ignoreChar != '\n');
    System.out.println(check.checkWord(Character.toLowerCase(guessChar)));
  }

}

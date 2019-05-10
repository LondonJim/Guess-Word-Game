package guess;

public class GuessGame {

  private GetRandomWord getRandomWord;

  public void main(String[] args) {
    GuessGame guessGame = new GuessGame();
    guessGame.play();
  }

  public void play() {
    this.getRandomWord = new GetRandomWord();
    getRandomWord.getWord();
  }

}

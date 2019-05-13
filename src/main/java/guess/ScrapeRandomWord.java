package guess;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeRandomWord {

  private String url;
  private String randomWord;
  private String randomWordMeaning;
  private Document doc;

  public ScrapeRandomWord() {
    this.url = "https://www.randomword.com";
  }

  public ScrapeRandomWord(String url) {
    this.url = url;
  }

  public void execute() {
    Elements word = getDocumentHelper().select("#random_word");
    Elements wordMeaning = getDocumentHelper().select("#random_word_definition");
    randomWordMeaning = wordMeaning.text();
    randomWord = word.text();
  }

  public Document getDocumentHelper() {
    if (doc == null) {
      try {
        doc = Jsoup.connect(url).get();
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
    return doc;
  }

  public String getRandomWord() {
    return randomWord;
  }

  public String getRandomWordMeaning() {
    return randomWordMeaning;
  }

}

package guess;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {

  private String url;
  private String randomWord;
  private String randomWordMeaning;
  private Document doc;

  public Scraper() {
    this.url = "https://www.randomword.com";
  }

  public Scraper(String url) {
    this.url = url;
  }

  public void execute() {
    doc = getDocumentHelper();
    Elements word = doc.select("#random_word");
    Elements wordMeaning = doc.select("#random_word_definition");
    randomWordMeaning = wordMeaning.text();
    randomWord = word.text();
  }

  public Document getDocumentHelper() {
    try {
      doc = Jsoup.connect(url).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doc;
  }

  public String getRandomWord() {
    return randomWord;
  }

  public String getRandomWordMeaning() {
    return randomWordMeaning;
  }

}

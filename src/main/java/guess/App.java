package guess;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

  private String url = "http://www.randomword.com";
  private String randomWord = "";

  public App() {}

  public String getWord() {
    Elements word = getDocumentHelper().select("#random_word");
    randomWord = word.text();
    System.out.println(randomWord);
    return randomWord;
  }

  public Document getDocumentHelper() {
    Document doc = null;
    try {
      doc = Jsoup.connect(url).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doc;
  }
}

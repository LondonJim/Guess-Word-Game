package guess;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetRandomWord {

  private String url;
  private String randomWord;

  public GetRandomWord() {
    this.url = "https://www.randomword.com";
  }

  public GetRandomWord(String url) {
    this.url = url;
  }

  public String getWord() {
    Elements word = getDocumentHelper().select("#random_word");
    randomWord = word.text();
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

package guess;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AppTest {

    @Test public void testgetWordReturnsString() {
      Document document = Jsoup.parse("<html><head></head><body><div id='random_word'>test</div></body><html>");
      App appMock = spy(App.class);
      when(appMock.getDocumentHelper()).thenReturn(document);

      assertEquals("test", appMock.getWord());
    }
}

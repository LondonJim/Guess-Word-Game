package guess;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CheckTest {

    // #convertWord
    @Test public void testConvertWordReturnWordArray() {
      Check check = new Check("test");
      char[] wordTestReturn = {'t', 'e', 's', 't'};

      assertEquals(Arrays.toString(wordTestReturn), Arrays.toString(check.convertWord()));
    }

    // #guessChars
    @Test public void testGuessCharsReturnGuessesArray() {
      Check check = new Check("test");
      check.guessChars('a');
      check.guessChars('b');
      check.guessChars('c');
      char[] charsTestReturn = {'a', 'b', 'c', 'd'};

      assertEquals(Arrays.toString(charsTestReturn), Arrays.toString(check.guessChars('d')));
    }
}

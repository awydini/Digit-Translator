package net.aydini.translate.number;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullSource;

import net.aydini.translate.number.exception.NumberTranslationException;
/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class OneDigitTranslatorTests
{

  public static class NumberArgumentProvider implements ArgumentsProvider
  {

      private Map<Integer,String> map = new HashMap<>();
      
      private Map<Integer,String> getMap()
      {
          map.put(-1, "منفی یک");
          map.put(0, "صفر");
          map.put(1, "یک");
          map.put(2, "دو");
          map.put(3, "سه");
          map.put(4, "چهار");
          map.put(-5, "منفی پنج");
          map.put(6, "شش");
          map.put(7, "هفت");
          map.put(8, "هشت");
          map.put(9, "نه");
          map.put(-9, "منفی نه");
          return map;
      }
      
      @Override
      public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception
      {
          return getMap().entrySet().stream().map(item->Arguments.of(item));
      }
      
  }
  
  @ParameterizedTest
  @ArgumentsSource(value =NumberArgumentProvider.class)
  public void shouldDetermineNumbersLessThanTen(Map.Entry<Integer, String> entry)
  {
      OneDigitTranslator odt = new OneDigitTranslator();
      assertEquals(entry.getValue(), odt.translate(Long.valueOf(entry.getKey())));
  }
  
  
  @ParameterizedTest
  @NullSource
  public void shouldThrowNumberTranslationException(Long number)
  {
      OneDigitTranslator odt = new OneDigitTranslator();
      assertThrows(NumberTranslationException.class,()-> odt.translate(number));
  }
}

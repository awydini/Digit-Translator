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
public class TwoDigitsTranslatorTests
{
    
    public static class NumberArgumentProvider implements ArgumentsProvider
    {

        private Map<Integer,String> map = new HashMap<>();
        
        private Map<Integer,String> getMap()
        {
            map.put(-11, "منفی یازده");
            map.put(10, "ده");
            map.put(19, "نوزده");
            map.put(20, "بیست");
            map.put(32, "سی و دو");
            map.put(45, "چهل و پنج");
            map.put(-45, "منفی چهل و پنج");
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
        TwoDigitsTranslator tdt = new TwoDigitsTranslator();
        assertEquals(entry.getValue(), tdt.translate(Long.valueOf(entry.getKey())));
    }
    
    
    @ParameterizedTest
    @NullSource
    public void shouldThrowNumberTranslationException(Long number)
    {
        TwoDigitsTranslator tdt = new TwoDigitsTranslator();
        assertThrows(NumberTranslationException.class,()-> tdt.translate(number));
    }

}

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
public class ThreeDigitsTranslatorTests
{
    
    public static class NumberArgumentProvider implements ArgumentsProvider
    {

        private Map<Integer,String> map = new HashMap<>();
        
        private Map<Integer,String> getMap()
        {
            map.put(-111, "منفی صد و یازده");
            map.put(100, "صد");
            map.put(406, "چهارصد و شش");
            map.put(999, "نهصد و نود و نه");
            map.put(-999, "منفی نهصد و نود و نه");
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
        ThreeDigitsTranslator tdt = new ThreeDigitsTranslator();
        assertEquals(entry.getValue(), tdt.translate(Long.valueOf(entry.getKey())));
    }
    
    
    @ParameterizedTest
    @NullSource
    public void shouldThrowNumberTranslationException(Long number)
    {
        ThreeDigitsTranslator tdt = new ThreeDigitsTranslator();
        assertThrows(NumberTranslationException.class,()-> tdt.translate(number));
    }

}

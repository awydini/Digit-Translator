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
public class MillionRangeTranslatorTests
{
    
    public static class NumberArgumentProvider implements ArgumentsProvider
    {

        private Map<Long,String> map = new HashMap<>();
        
        private Map<Long,String> getMap()
        {
            map.put(-1000001l, "منفی یک ملیون و یک");
            map.put(-17123456l, "منفی هفده ملیون و صد و بیست و سه هزار و چهارصد و پنجاه و شش");
            map.put(900000001l, "نهصد ملیون و یک");
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
    public void shouldDetermineNumbersLessThanTen(Map.Entry<Long, String> entry)
    {
        MillionRangeTranslator tdt = new MillionRangeTranslator();
        assertEquals(entry.getValue(), tdt.translate(entry.getKey()));
    }
    
    
    @ParameterizedTest
    @NullSource
    public void shouldThrowNumberTranslationException(Long number)
    {
        MillionRangeTranslator tdt = new MillionRangeTranslator();
        assertThrows(NumberTranslationException.class,()-> tdt.translate(number));
    }

}

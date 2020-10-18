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
public class ThousandRangeTranslatorTests
{
    
    public static class NumberArgumentProvider implements ArgumentsProvider
    {

        private Map<Long,String> map = new HashMap<>();
        
        private Map<Long,String> getMap()
        {
            map.put(-1111l, "منفی یک هزار و صد و یازده");
            map.put(1000l, "هزار");
            map.put(6406l, "شش هزار و چهارصد و شش");
            map.put(9999l, "نه هزار و نهصد و نود و نه");
            map.put(-9999l, "منفی نه هزار و نهصد و نود و نه");
            map.put(-11111l, "منفی یازده هزار و صد و یازده");
            map.put(10000l, "ده هزار");
            map.put(64046l, "شصت و چهار هزار و چهل و شش");
            map.put(99999l, "نود و نه هزار و نهصد و نود و نه");
            map.put(-99999l, "منفی نود و نه هزار و نهصد و نود و نه");
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
        ThousandRangeTranslator tdt = new ThousandRangeTranslator();
        assertEquals(entry.getValue(), tdt.translate(Long.valueOf(entry.getKey())));
    }
    
    
    @ParameterizedTest
    @NullSource
    public void shouldThrowNumberTranslationException(Long number)
    {
        ThousandRangeTranslator tdt = new ThousandRangeTranslator();
        assertThrows(NumberTranslationException.class,()-> tdt.translate(number));
    }

}

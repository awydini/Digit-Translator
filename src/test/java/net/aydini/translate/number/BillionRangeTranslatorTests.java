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
public class BillionRangeTranslatorTests
{
    
    public static class NumberArgumentProvider implements ArgumentsProvider
    {

        private Map<Long,String> map = new HashMap<>();
        
        private Map<Long,String> getMap()
        {
            map.put(-1000000001l, "منفی یک میلیارد و یک");
            map.put(999555111222l, "نهصد و نود و نه میلیارد و پانصد و پنجاه و پنج ملیون و صد و یازده هزار و دویست و بیست و دو");
            map.put(3000000000000l, "سه هزار میلیارد");
            map.put(300000000000000l, "سیصد هزار میلیارد");
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
        BillionRangeTranslator tdt = new BillionRangeTranslator();
        assertEquals(entry.getValue(), tdt.translate(entry.getKey()));
    }
    
    
    @ParameterizedTest
    @NullSource
    public void shouldThrowNumberTranslationException(Long number)
    {
        BillionRangeTranslator tdt = new BillionRangeTranslator();
        assertThrows(NumberTranslationException.class,()-> tdt.translate(number));
    }

}

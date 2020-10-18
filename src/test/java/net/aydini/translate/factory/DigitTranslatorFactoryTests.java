package net.aydini.translate.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.aydini.translate.number.BillionRangeTranslator;
import net.aydini.translate.number.MillionRangeTranslator;
import net.aydini.translate.number.OneDigitTranslator;
import net.aydini.translate.number.ThousandRangeTranslator;
import net.aydini.translate.number.ThreeDigitsTranslator;
import net.aydini.translate.number.TwoDigitsTranslator;
/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class DigitTranslatorFactoryTests
{
    
    @Test
    public void shouldCreateOneDigitTranslatorInstanse()
    {
        assertTrue(DigitTranslatorFactory.createInstance(1) instanceof OneDigitTranslator);
    }
    
    @Test
    public void shouldCreateTwoDigitsTranslatorInstanse()
    {
        assertTrue(DigitTranslatorFactory.createInstance(-99) instanceof TwoDigitsTranslator);
    }

    @Test
    public void shouldCreateThreeDigitsTranslatorInstanse()
    {
        assertTrue(DigitTranslatorFactory.createInstance(-999) instanceof ThreeDigitsTranslator);
    }
    
    @Test
    public void shouldCreateThousandRangeTranslatorInstanse()
    {
        assertTrue(DigitTranslatorFactory.createInstance(-9999) instanceof ThousandRangeTranslator);
    }
    
    @Test
    public void shouldCreateMillionRangeTranslatorInstanse()
    {
        assertTrue(DigitTranslatorFactory.createInstance(-9999999) instanceof MillionRangeTranslator);
    }
    
    @Test
    public void shouldCreateBillionRangeTranslatorInstanse()
    {
        assertTrue(DigitTranslatorFactory.createInstance(-9999999999999l) instanceof BillionRangeTranslator);
    }

}

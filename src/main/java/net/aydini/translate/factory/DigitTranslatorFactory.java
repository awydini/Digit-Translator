package net.aydini.translate.factory;

import net.aydini.translate.number.BillionRangeTranslator;
import net.aydini.translate.number.MillionRangeTranslator;
import net.aydini.translate.number.NumberTranslator;
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
public class DigitTranslatorFactory
{

    public static NumberTranslator createInstance(long number)
    {
        long num = Math.abs(number);

        if      (num < 10) return new OneDigitTranslator();
        else if (num < 100) return new TwoDigitsTranslator();
        else if (num < 1000) return new ThreeDigitsTranslator();
        else if (num < 1000000) return new ThousandRangeTranslator();
        else if (num < 1000000000) return new MillionRangeTranslator();
        else return new BillionRangeTranslator();

    }

}

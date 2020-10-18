package net.aydini.translate.number;

import java.util.HashMap;
import java.util.Map;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class MillionRangeTranslator extends AbstractDigitTranslator
{

    private static final Integer THOUSAND = 1000000;
    private static final String THOUSAND_STRING = "ملیون";

    
    private static final Map<Long, String> FOUR_DIGIT_NUMBER_TRANSLATION;
    static
    {
        FOUR_DIGIT_NUMBER_TRANSLATION = new HashMap<>();
        
        FOUR_DIGIT_NUMBER_TRANSLATION.put(1000l, "ملیون");
        FOUR_DIGIT_NUMBER_TRANSLATION.put(10000l, "ده ملیون");
        FOUR_DIGIT_NUMBER_TRANSLATION.put(100000l, "صد ملیون");
    }
    public MillionRangeTranslator()
    {
        super(999999999l);
    }

    @Override
    public String translateNumber(Long number)
    {

        if (FOUR_DIGIT_NUMBER_TRANSLATION.get(number) != null)
            return FOUR_DIGIT_NUMBER_TRANSLATION.get(number);

        StringBuilder stringBuilder = new StringBuilder();

        long xThousand = number / THOUSAND;
        NumberTranslator oneDigitTranslator = DigitTranslatorFactory.createInstance(xThousand);

        NumberTranslator remainingDigitsTranslator = DigitTranslatorFactory.createInstance(number % THOUSAND);

        stringBuilder.append(oneDigitTranslator.translate(xThousand)).append(" ")
        .append(THOUSAND_STRING);
        if(number % THOUSAND != 0)
            stringBuilder.append(" ").append("و").append(" ").append(remainingDigitsTranslator.translate(number % THOUSAND));
        return stringBuilder.toString();
    }

}

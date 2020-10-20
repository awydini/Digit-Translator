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
public class ThousandRangeTranslator extends AbstractDigitTranslator
{

    private static final Integer THOUSAND = 1000;
    private static final String THOUSAND_STRING = "thousand";

    
    private static final Map<Long, String> THOUSAND_NUMBER_TRANSLATION;
    static
    {
        THOUSAND_NUMBER_TRANSLATION = new HashMap<>();
        
        THOUSAND_NUMBER_TRANSLATION.put(1000l, "thousand");
    }
    public ThousandRangeTranslator()
    {
        super(999999999l);
    }

    @Override
    public void translateNumber(Long number)
    {

        if (THOUSAND_NUMBER_TRANSLATION.get(number) != null)
        {
            messageQueue.addToQue(THOUSAND_NUMBER_TRANSLATION.get(number));
            return;
        }

        long xThousand = number / THOUSAND;
        NumberTranslator oneDigitTranslator = DigitTranslatorFactory.createInstance(xThousand);
        NumberTranslator remainingDigitsTranslator = DigitTranslatorFactory.createInstance(number % THOUSAND);

        messageQueue.addToQue(oneDigitTranslator.translate(xThousand)).addToQue(" ")
        .addToQue(THOUSAND_STRING);
        if(number % THOUSAND != 0)
            messageQueue.addToQue(" ").addToQue("and").addToQue(" ").addToQue(remainingDigitsTranslator.translate(number % THOUSAND));
    }

}

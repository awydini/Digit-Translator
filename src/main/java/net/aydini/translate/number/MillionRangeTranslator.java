package net.aydini.translate.number;

import java.util.HashMap;
import java.util.Map;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 *         Oct 18, 2020
 */
public class MillionRangeTranslator extends AbstractDigitTranslator
{

    private static final Integer THOUSAND = 1000000;
    private static final String THOUSAND_STRING = "million";

    private static final Map<Long, String> FOUR_DIGIT_NUMBER_TRANSLATION;
    static
    {
        FOUR_DIGIT_NUMBER_TRANSLATION = new HashMap<>();

        FOUR_DIGIT_NUMBER_TRANSLATION.put(1000l, "million");
        FOUR_DIGIT_NUMBER_TRANSLATION.put(10000l, "ten-million");
        FOUR_DIGIT_NUMBER_TRANSLATION.put(100000l, "one-hundred-million");
    }

    public MillionRangeTranslator()
    {
        super(999999999l);
    }

    @Override
    public void translateNumber(Long number)
    {

        if (FOUR_DIGIT_NUMBER_TRANSLATION.get(number) != null)
        {
            messageQueue.addToQue(FOUR_DIGIT_NUMBER_TRANSLATION.get(number));
            return;
        }


        long xThousand = number / THOUSAND;
        NumberTranslator oneDigitTranslator = DigitTranslatorFactory.createInstance(xThousand);

        NumberTranslator remainingDigitsTranslator = DigitTranslatorFactory.createInstance(number % THOUSAND);

        messageQueue.addToQue(oneDigitTranslator.translate(xThousand)).addToQue(" ").addToQue(THOUSAND_STRING);
        if (number % THOUSAND != 0)
            messageQueue.addToQue(" ").addToQue("و").addToQue(" ").addToQue(remainingDigitsTranslator.translate(number % THOUSAND));
    }

}

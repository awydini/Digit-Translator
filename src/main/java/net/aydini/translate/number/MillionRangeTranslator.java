package net.aydini.translate.number;

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


    public MillionRangeTranslator()
    {
        super(999999999l);
    }

    @Override
    public void translateNumber(Long number)
    {

        long xThousand = number / THOUSAND;
        NumberTranslator oneDigitTranslator = DigitTranslatorFactory.createInstance(xThousand);

        NumberTranslator remainingDigitsTranslator = DigitTranslatorFactory.createInstance(number % THOUSAND);

        messageQueue.addToQue(oneDigitTranslator.translate(xThousand)).addToQue(" ").addToQue(THOUSAND_STRING);
        if (number % THOUSAND != 0)
            messageQueue.addToQue(" ").addToQue("و").addToQue(" ").addToQue(remainingDigitsTranslator.translate(number % THOUSAND));
    }

}

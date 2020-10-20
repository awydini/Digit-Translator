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


    public MillionRangeTranslator()
    {
        super(999999999l);
    }

    @Override
    public void translateNumber(Long number)
    {

        long xThousand = number / Constant.MILLION;
        NumberTranslator oneDigitTranslator = DigitTranslatorFactory.createInstance(xThousand);

        NumberTranslator remainingDigitsTranslator = DigitTranslatorFactory.createInstance(number % Constant.MILLION);

        messageQueue.addToQue(oneDigitTranslator.translate(xThousand)).addToQue(" ").addToQue(Constant.MILLION_RANGE.get(Constant.MILLION));
        if (number % Constant.MILLION != 0)
            messageQueue.addToQue(" ").addToQue("و").addToQue(" ").addToQue(remainingDigitsTranslator.translate(number % Constant.MILLION));
    }

}

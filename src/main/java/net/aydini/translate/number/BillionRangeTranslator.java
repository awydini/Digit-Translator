package net.aydini.translate.number;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 *         Oct 18, 2020
 */
public class BillionRangeTranslator extends AbstractDigitTranslator
{

    

    public BillionRangeTranslator()
    {
        super(Long.MAX_VALUE);
    }

    @Override
    public void translateNumber(Long number)
    {

        long xThousand = number / Constant.BILLION;
        NumberTranslator oneDigitTranslator = DigitTranslatorFactory.createInstance(xThousand);

        NumberTranslator remainingDigitsTranslator = DigitTranslatorFactory.createInstance(number % Constant.BILLION);

        messageQueue.addToQue(oneDigitTranslator.translate(xThousand)).addToQue(" ").addToQue(Constant.BILLION_RANGE.get(Constant.BILLION));
        if (number % Constant.BILLION != 0)
            messageQueue.addToQue(" ").addToQue("و").addToQue(" ").addToQue(remainingDigitsTranslator.translate(number % Constant.BILLION));
    }

}

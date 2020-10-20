package net.aydini.translate.number;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class ThousandRangeTranslator extends AbstractDigitTranslator
{
    
    public ThousandRangeTranslator()
    {
        super(999999999l);
    }

    @Override
    public void translateNumber(Long number)
    {

        String translation = Constant.THOUSAND_RANGE.get(number);
        if (translation != null)
        {
            messageQueue.addToQue(translation);
            return;
        }

        long xThousand = number / Constant.THOUSAND;
        NumberTranslator oneDigitTranslator = DigitTranslatorFactory.createInstance(xThousand);
        NumberTranslator remainingDigitsTranslator = DigitTranslatorFactory.createInstance(number % Constant.THOUSAND);

        messageQueue.addToQue(oneDigitTranslator.translate(xThousand)).addToQue(" ")
        .addToQue(Constant.THOUSAND_RANGE.get(Constant.THOUSAND));
        if(number % Constant.THOUSAND != 0)
            messageQueue.addToQue(" ").addToQue("and").addToQue(" ").addToQue(remainingDigitsTranslator.translate(number % Constant.THOUSAND));
    }

}

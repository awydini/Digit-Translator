package net.aydini.translate.number;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 *         Oct 18, 2020
 */
public class TwoDigitsTranslator extends AbstractDigitTranslator
{
    
    static
    {
        

    }

    public TwoDigitsTranslator()
    {
        super(99l);
    }

    @Override
    public void translateNumber(Long number)
    {
        String translation = Constant.TWO_DIGIT.get(number);
        if (translation != null)
        {
            messageQueue.addToQue(translation);
            return;
        }
        NumberTranslator numberTranslator = DigitTranslatorFactory.createInstance(number % 10);
        messageQueue.addToQue(Constant.TWO_DIGIT.get((number / 10) * 10)).addToQue(" ").addToQue("and").addToQue(" ")
                .addToQue(numberTranslator.translate(number % 10));
    }

}

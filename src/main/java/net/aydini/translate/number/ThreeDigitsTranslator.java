package net.aydini.translate.number;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 *         Oct 18, 2020
 */
public class ThreeDigitsTranslator extends AbstractDigitTranslator
{
    

    public ThreeDigitsTranslator()
    {
        super(999l);
    }

    @Override
    public void translateNumber(Long number)
    {
        String translation = Constant.THREE_DIGIT.get(number);
        if (translation != null)
        {
            messageQueue.addToQue(translation);
            return;
        }
        NumberTranslator numberTranslator = DigitTranslatorFactory.createInstance(number % 100);
        messageQueue.addToQue(Constant.THREE_DIGIT.get((number / 100) * 100))
        .addToQue(" ").addToQue("and").addToQue(" ")
        .addToQue(numberTranslator.translate(number % 100));
    }

}

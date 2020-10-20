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
public class TwoDigitsTranslator extends AbstractDigitTranslator
{
    private static final Map<Long, String> TWO_DIGIT_NUMBER_TRANSLATION;
    static
    {
        TWO_DIGIT_NUMBER_TRANSLATION = new HashMap<>();

        TWO_DIGIT_NUMBER_TRANSLATION.put(10l, "ten");
        TWO_DIGIT_NUMBER_TRANSLATION.put(11l, "eleven");
        TWO_DIGIT_NUMBER_TRANSLATION.put(12l, "twelve");
        TWO_DIGIT_NUMBER_TRANSLATION.put(13l, "thirteen");
        TWO_DIGIT_NUMBER_TRANSLATION.put(14l, "fourteen");
        TWO_DIGIT_NUMBER_TRANSLATION.put(15l, "fifteenth");
        TWO_DIGIT_NUMBER_TRANSLATION.put(16l, "sixteen");
        TWO_DIGIT_NUMBER_TRANSLATION.put(17l, "seventeen");
        TWO_DIGIT_NUMBER_TRANSLATION.put(18l, "eighteen");
        TWO_DIGIT_NUMBER_TRANSLATION.put(19l, "nineteen");
        TWO_DIGIT_NUMBER_TRANSLATION.put(20l, "twenty");
        TWO_DIGIT_NUMBER_TRANSLATION.put(30l, "thirty");
        TWO_DIGIT_NUMBER_TRANSLATION.put(40l, "forty");
        TWO_DIGIT_NUMBER_TRANSLATION.put(50l, "fifty");
        TWO_DIGIT_NUMBER_TRANSLATION.put(60l, "sixty");
        TWO_DIGIT_NUMBER_TRANSLATION.put(70l, "seventy");
        TWO_DIGIT_NUMBER_TRANSLATION.put(80l, "eighty");
        TWO_DIGIT_NUMBER_TRANSLATION.put(90l, "ninety");

    }

    public TwoDigitsTranslator()
    {
        super(99l);
    }

    @Override
    public void translateNumber(Long number)
    {
        if (number / 10 < 2 || number % 10 == 0)
        {
            messageQueue.addToQue(TWO_DIGIT_NUMBER_TRANSLATION.get(number));
            return;
        }
        NumberTranslator numberTranslator = DigitTranslatorFactory.createInstance(number % 10);
        messageQueue.addToQue(TWO_DIGIT_NUMBER_TRANSLATION.get((number / 10) * 10)).addToQue(" ").addToQue("and").addToQue(" ")
                .addToQue(numberTranslator.translate(number % 10));
    }

}

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
public class ThreeDigitsTranslator extends AbstractDigitTranslator
{
    private static final Map<Long, String> THREE_DIGIT_NUMBER_TRANSLATION;
    static
    {
        THREE_DIGIT_NUMBER_TRANSLATION = new HashMap<>();

        THREE_DIGIT_NUMBER_TRANSLATION.put(100l, "one-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(200l, "two-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(300l, "three-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(400l, "four-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(500l, "five-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(600l, "six-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(700l, "seven-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(800l, "eight-hundred");
        THREE_DIGIT_NUMBER_TRANSLATION.put(900l, "nine-hundred");
    }

    public ThreeDigitsTranslator()
    {
        super(999l);
    }

    @Override
    public void translateNumber(Long number)
    {
        if (number % 100 == 0)
        {
            messageQueue.addToQue(THREE_DIGIT_NUMBER_TRANSLATION.get(number));
            return;
        }
        NumberTranslator numberTranslator = DigitTranslatorFactory.createInstance(number % 100);
        messageQueue.addToQue(THREE_DIGIT_NUMBER_TRANSLATION.get((number / 100) * 100))
        .addToQue(" ").addToQue("and").addToQue(" ")
        .addToQue(numberTranslator.translate(number % 100));
    }

}

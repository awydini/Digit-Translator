package net.aydini.translate.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class OneDigitTranslator extends AbstractDigitTranslator
{
    private static final Map<Long, String> ONE_DIGIT_NUMBER_TRANSLATION;
    static
    {
        ONE_DIGIT_NUMBER_TRANSLATION = new HashMap<>();
        ONE_DIGIT_NUMBER_TRANSLATION.put(0l, "zero");
        ONE_DIGIT_NUMBER_TRANSLATION.put(1l, "one");
        ONE_DIGIT_NUMBER_TRANSLATION.put(2l, "two");
        ONE_DIGIT_NUMBER_TRANSLATION.put(3l, "three");
        ONE_DIGIT_NUMBER_TRANSLATION.put(4l, "four");
        ONE_DIGIT_NUMBER_TRANSLATION.put(5l, "five");
        ONE_DIGIT_NUMBER_TRANSLATION.put(6l, "six");
        ONE_DIGIT_NUMBER_TRANSLATION.put(7l, "seven");
        ONE_DIGIT_NUMBER_TRANSLATION.put(8l, "eight");
        ONE_DIGIT_NUMBER_TRANSLATION.put(9l, "nine");

    }
    
    public OneDigitTranslator()
    {
        super(9l);
    }
    
    

    @Override
    public void translateNumber(Long number)
    {
        messageQueue.addToQue(ONE_DIGIT_NUMBER_TRANSLATION.get(number));
    }



    
    


    
    
}

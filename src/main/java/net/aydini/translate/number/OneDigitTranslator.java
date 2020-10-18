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
        ONE_DIGIT_NUMBER_TRANSLATION.put(0l, "صفر");
        ONE_DIGIT_NUMBER_TRANSLATION.put(1l, "یک");
        ONE_DIGIT_NUMBER_TRANSLATION.put(2l, "دو");
        ONE_DIGIT_NUMBER_TRANSLATION.put(3l, "سه");
        ONE_DIGIT_NUMBER_TRANSLATION.put(4l, "چهار");
        ONE_DIGIT_NUMBER_TRANSLATION.put(5l, "پنج");
        ONE_DIGIT_NUMBER_TRANSLATION.put(6l, "شش");
        ONE_DIGIT_NUMBER_TRANSLATION.put(7l, "هفت");
        ONE_DIGIT_NUMBER_TRANSLATION.put(8l, "هشت");
        ONE_DIGIT_NUMBER_TRANSLATION.put(9l, "نه");

    }
    
    public OneDigitTranslator()
    {
        super(9l);
    }
    
    

    @Override
    public String translateNumber(Long number)
    {
        return ONE_DIGIT_NUMBER_TRANSLATION.get(number);
    }



    
    


    
    
}

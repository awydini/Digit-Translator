package net.aydini.translate.number;

import java.util.HashMap;
import java.util.Map;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class ThreeDigitsTranslator extends AbstractDigitTranslator
{
    private static final Map<Long, String> THREE_DIGIT_NUMBER_TRANSLATION;
    static
    {
        THREE_DIGIT_NUMBER_TRANSLATION = new HashMap<>();
        
        THREE_DIGIT_NUMBER_TRANSLATION.put(100l, "صد");
        THREE_DIGIT_NUMBER_TRANSLATION.put(200l, "دویست");
        THREE_DIGIT_NUMBER_TRANSLATION.put(300l, "سیصد");
        THREE_DIGIT_NUMBER_TRANSLATION.put(400l, "چهارصد");
        THREE_DIGIT_NUMBER_TRANSLATION.put(500l, "پانصد");
        THREE_DIGIT_NUMBER_TRANSLATION.put(600l, "ششصد");
        THREE_DIGIT_NUMBER_TRANSLATION.put(700l, "هفتصد");
        THREE_DIGIT_NUMBER_TRANSLATION.put(800l, "هشتصد");
        THREE_DIGIT_NUMBER_TRANSLATION.put(900l, "نهصد");
    }
    
    public ThreeDigitsTranslator()
    {
        super(999l);
    }
    

    @Override
    public String translateNumber(Long number)
    {
        if(number%100==0)
            return THREE_DIGIT_NUMBER_TRANSLATION.get(number);
        
        StringBuilder stringBuilder = new StringBuilder();
        
        NumberTranslator numberTranslator = DigitTranslatorFactory.createInstance(number%100);
        
        
        stringBuilder.append(THREE_DIGIT_NUMBER_TRANSLATION.get((number/100)*100)).append(" ").append("و")
            .append(" ").append(numberTranslator.translate(number%100));
        return stringBuilder.toString();
    }



    
    


    
    
}

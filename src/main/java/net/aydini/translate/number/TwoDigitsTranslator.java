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
public class TwoDigitsTranslator extends AbstractDigitTranslator
{
    private static final Map<Long, String> TWO_DIGIT_NUMBER_TRANSLATION;
    static
    {
        TWO_DIGIT_NUMBER_TRANSLATION = new HashMap<>();
        
        TWO_DIGIT_NUMBER_TRANSLATION.put(10l, "ده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(11l, "یازده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(12l, "دوازده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(13l, "سیزده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(14l, "چهارده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(15l, "پانزده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(16l, "شانزده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(17l, "هفده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(18l, "هجده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(19l, "نوزده");
        TWO_DIGIT_NUMBER_TRANSLATION.put(20l, "بیست");
        TWO_DIGIT_NUMBER_TRANSLATION.put(30l, "سی");
        TWO_DIGIT_NUMBER_TRANSLATION.put(40l, "چهل");
        TWO_DIGIT_NUMBER_TRANSLATION.put(50l, "پنجاه");
        TWO_DIGIT_NUMBER_TRANSLATION.put(60l, "شصت");
        TWO_DIGIT_NUMBER_TRANSLATION.put(70l, "هفتاد");
        TWO_DIGIT_NUMBER_TRANSLATION.put(80l, "هشتاد");
        TWO_DIGIT_NUMBER_TRANSLATION.put(90l, "نود");

    }
    
    public TwoDigitsTranslator()
    {
        super(99l);
    }
    

    @Override
    public String translateNumber(Long number)
    {
        if(number/10 < 2 || number%10==0)
            return TWO_DIGIT_NUMBER_TRANSLATION.get(number);
        
        StringBuilder stringBuilder = new StringBuilder();
        NumberTranslator numberTranslator = DigitTranslatorFactory.createInstance(number%10);
        stringBuilder.append(TWO_DIGIT_NUMBER_TRANSLATION.get((number/10)*10)).append(" ").append("و").append(" ").append(numberTranslator.translate(number%10));
        return stringBuilder.toString();
    }



    
    


    
    
}

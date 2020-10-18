package net.aydini.translate;

import net.aydini.translate.factory.DigitTranslatorFactory;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class DigitTranslator
{
    
    public static String translate(Long number)
    {
        return DigitTranslatorFactory.createInstance(number).translate(number);
    }

}

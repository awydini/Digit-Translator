package net.aydini.translate.sign;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class SignTranslator
{
    private static final Map<Boolean, String> SIGN_TRANSLATION;

    static
    {
        SIGN_TRANSLATION = new HashMap<Boolean, String>();
        SIGN_TRANSLATION.put(true, "منفی");
        SIGN_TRANSLATION.put(false, "مثبت");
        SIGN_TRANSLATION.put(null, "");
    }
    
    /**
     * 
     * @param number
     * @throws NullPointerException 
     * @return
     */
    public String translateSign(Long number)
    {
        if(number == null)
            throw new NullPointerException("number is null");
        if(number == 0)
            return getSign(false,true);
        return getSign(number < 0, true);
    }
    
    private String getSign(Boolean isNegetive,boolean emptyForPositive)
    {
        if(emptyForPositive && !isNegetive)
            return "";
        return SIGN_TRANSLATION.get(isNegetive);
        
    }

}

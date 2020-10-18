package net.aydini.translate.number;

import net.aydini.translate.number.exception.NumberTranslationException;
import net.aydini.translate.sign.SignTranslator;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public abstract class AbstractDigitTranslator implements NumberTranslator, NumberValidator
{

    protected SignTranslator signTranslator =new SignTranslator();
    
    private final Long maxRange;
    
    private  boolean negative;

    public AbstractDigitTranslator(Long maxRange)
    {
        this.maxRange=maxRange;
    }
    
    public void validate(Long number)
    {
        if(number == null )
            throw new NumberTranslationException("number is null");
        if(Math.abs(number) >getMaxRange().longValue())
            throw new NumberTranslationException("wrong range number");
    }
    
    public String translate(Long number)
    {
        validate(number);
        setNegetive(number.longValue()<0l);
        String sign = signTranslator.translateSign(number);
        if(!sign.equals(""))
            sign = sign + " ";
        return  sign + translateNumber(Math.abs(number));
    }
    
    public abstract String translateNumber(Long number);


    public Long getMaxRange()
    {
        return maxRange;
    }

    
    public boolean isNegative()
    {
        return negative;
    }

    private void setNegetive(boolean negative)
    {
        this.negative=negative;
    }
    
}

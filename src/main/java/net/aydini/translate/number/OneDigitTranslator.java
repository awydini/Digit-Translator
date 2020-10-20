package net.aydini.translate.number;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class OneDigitTranslator extends AbstractDigitTranslator
{
    
    
    
    public OneDigitTranslator()
    {
        super(9l);
    }
    
    

    @Override
    public void translateNumber(Long number)
    {
        messageQueue.addToQue(Constant.ONE_DIGIT.get(number));
    }



    
    


    
    
}

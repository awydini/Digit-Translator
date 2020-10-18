package net.aydini.translate.number.exception;
/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 18, 2020
 */
public class NumberTranslationException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    
    public NumberTranslationException(String message) {
        super(message);
    }
    
    public NumberTranslationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public NumberTranslationException(Throwable cause) {
        super(cause);
    }

}

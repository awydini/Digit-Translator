package net.aydini.translate.message;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 20, 2020
 */
public class MessageBundleutils
{
    
    private static  ResourceBundle getResourceBundle(Locale locale)
    {
        return ResourceBundle.getBundle("MessagesBundle",locale);
    }
    
    public static String getMessage(String message)
    {
        return getMessage(new Locale("fa"),message);
    }
    
    
    public static String getMessage(Locale locale ,String message)
    {
        try
        {
        return getResourceBundle(locale).getString(message);
        }
        catch(MissingResourceException e)
        {
            
        }
        return message;
    }

}

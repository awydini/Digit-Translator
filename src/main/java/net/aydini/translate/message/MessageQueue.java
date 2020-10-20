package net.aydini.translate.message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 * Oct 20, 2020
 */
public class MessageQueue
{
    
    private List<String> messageQueue;
    private MessageQueue()
    {
        messageQueue= new ArrayList<>();
    }

    public static MessageQueue getInstanse()
    {
      return new MessageQueue();  
    }
    
    
    
    public String translateMessageQue()
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        Stream<String> map = messageQueue.stream().map(MessageBundleutils::getMessage);
        map.forEach(item-> stringBuilder.append(item));
        
        return stringBuilder.toString();
    }
    
    public List<String> addToQue(String message)
    {
        messageQueue.add(message);
        return messageQueue;
    }
    
}

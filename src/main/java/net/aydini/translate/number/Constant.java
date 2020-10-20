package net.aydini.translate.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Author <a href="mailto:paakro@gmail.com">Aydin Nasrollahpour </a>
 *
 *         Oct 20, 2020
 */
public class Constant
{

    public static final Map<Long, String> ONE_DIGIT;
    public static final Map<Long, String> TWO_DIGIT;
    public static final Map<Long, String> THREE_DIGIT;
    public static final Map<Long, String> THOUSAND_RANGE;
    public static final Map<Long, String> MILLION_RANGE;
    public static final long THOUSAND = 1000l;
    public static final long MILLION = 1000000l;
    public static final long BILLION = 1000000000l;
    public static final Map<Long, String>  BILLION_RANGE;

    static
    {
        ONE_DIGIT = new HashMap<>();
        ONE_DIGIT.put(0l, "zero");
        ONE_DIGIT.put(1l, "one");
        ONE_DIGIT.put(2l, "two");
        ONE_DIGIT.put(3l, "three");
        ONE_DIGIT.put(4l, "four");
        ONE_DIGIT.put(5l, "five");
        ONE_DIGIT.put(6l, "six");
        ONE_DIGIT.put(7l, "seven");
        ONE_DIGIT.put(8l, "eight");
        ONE_DIGIT.put(9l, "nine");

        TWO_DIGIT = new HashMap<>();

        TWO_DIGIT.put(10l, "ten");
        TWO_DIGIT.put(11l, "eleven");
        TWO_DIGIT.put(12l, "twelve");
        TWO_DIGIT.put(13l, "thirteen");
        TWO_DIGIT.put(14l, "fourteen");
        TWO_DIGIT.put(15l, "fifteenth");
        TWO_DIGIT.put(16l, "sixteen");
        TWO_DIGIT.put(17l, "seventeen");
        TWO_DIGIT.put(18l, "eighteen");
        TWO_DIGIT.put(19l, "nineteen");
        TWO_DIGIT.put(20l, "twenty");
        TWO_DIGIT.put(30l, "thirty");
        TWO_DIGIT.put(40l, "forty");
        TWO_DIGIT.put(50l, "fifty");
        TWO_DIGIT.put(60l, "sixty");
        TWO_DIGIT.put(70l, "seventy");
        TWO_DIGIT.put(80l, "eighty");
        TWO_DIGIT.put(90l, "ninety");

        THREE_DIGIT = new HashMap<>();

        THREE_DIGIT.put(100l, "one-hundred");
        THREE_DIGIT.put(200l, "two-hundred");
        THREE_DIGIT.put(300l, "three-hundred");
        THREE_DIGIT.put(400l, "four-hundred");
        THREE_DIGIT.put(500l, "five-hundred");
        THREE_DIGIT.put(600l, "six-hundred");
        THREE_DIGIT.put(700l, "seven-hundred");
        THREE_DIGIT.put(800l, "eight-hundred");
        THREE_DIGIT.put(900l, "nine-hundred");

        THOUSAND_RANGE = new HashMap<>();

        THOUSAND_RANGE.put(1000l, "thousand");
        
        MILLION_RANGE = new HashMap<>();

        MILLION_RANGE.put(1000000l, "million");
        
        BILLION_RANGE = new HashMap<>();

        BILLION_RANGE.put(1000000000l, "billion");
        

    }
}

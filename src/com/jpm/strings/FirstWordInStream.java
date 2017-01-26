/*
Find the first word in a stream which is not repeated in the rest of the stream.
Please note that you are being provided a stream as a source for the characters.
The stream is guaranteed to eventually terminate (i.e. return false from a call to the hasNext() method), though it could be very long.
You will access this stream through the provided interface methods.
A call to hasNext() will return whether the stream contains any more characters to process.
A call to next() will return the next character to be processed in the stream.
It is not possible to restart the stream.

You can write any methods or classes you would like. However, all new classes must be written in this
file and you cannot change the FirstWordInStream class name, the Stream interface contract or the firstWord() method signature.

Example:
--------
	Input: "The angry dog was red. And the cat was also angry."
	Output: "dog"
In this example, the word "dog" is the first word in the stream which is not repeated in the rest of the stream.


*/

package com.jpm.strings;

import java.util.LinkedHashSet;

/**
 * Created by fagracas on 01/18/2017.
 */

public class FirstWordInStream
{
    public interface Stream
    {
        char next();
        boolean hasNext();
    }

    public String firstWord(final Stream input)
    {
        char ch;
        StringBuilder word = new StringBuilder();
        LinkedHashSet<String> words = new LinkedHashSet<>();

        while (input.hasNext())
        {
            ch = input.next();
            if (ch != ' ' || ch != '.' || ch != ',')
                word.append(ch);
            else
            {
                if (!words.contains(word.toString().toLowerCase()))
                    words.add(word.toString().toLowerCase());
                else
                    words.remove(word.toString().toLowerCase());

                word.setLength(0);
            }
        }

        if (words.isEmpty())
            return "";
        else
            return words.iterator().next();
    }
}

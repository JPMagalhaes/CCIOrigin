package com.jpm.arrays;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by fagracas on 01/30/2017.
 */
public class SumRepeatedOddNumbers
{
    public static ArrayList<Integer> GetSumReaptedOddNumbers(int[] values)
    {
        Integer value = 0;
        HashMap<Integer, Integer> temp = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < values.length; ++i)
        {
            if (values[i] % 2 != 0)
            {
                if (!temp.containsKey(values[i]))
                    temp.put(values[i], 1);
                else
                    temp.put(values[i], temp.get(values[i]) + 1);
            }
        }

        for (Integer key: temp.keySet())
        {
            value = temp.get(key);
            if (value >= 3 && (value % 2 != 0))
                result.add(value);
        }

        return result;
    }
}

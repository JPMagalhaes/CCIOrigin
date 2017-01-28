package com.jpm.arrays;

import java.util.Arrays;

/**
 * Created by fagracas on 01/28/2017.
 *
 * Implementar um método que, dados dois parâmetros de entrada -
 * um array de inteiros e um inteiro chamado target -
 * encontre no array um par de números cuja soma seja igual ao valor do target.
 * 
 */
public class GetPairSum {
    public int[] findPair(int[] numbers, int target) {
        int[] result = new int[2];

        Arrays.sort(numbers);
        int high = numbers.length - 1;

        for (int i = 0; i < numbers.length;) {

            if (numbers[i] + numbers[high] == target) {
                result[0] = numbers[i];
                result[1] = numbers[high];
                break;
            }

            if (numbers[i] + numbers[high] < target)
                i++;

            if (numbers[i] + numbers[high] > target)
                high--;

            if (high <= i)
                return null;
        }

        return result;
    }
}
package com.jpm.strings;

/*
Amazon wants to implement a new backup system, in which files are stored into data tapes.

This new system must follow the following 2 rules:
	1. Never place more than two files on the same tape.
	2. Files cannot be split across multiple tapes.

It is guaranteed that all tapes have the same size and that they will always be able to store the largest file.
Every time this process is executed, we already know the size of each file, and the capacity of the tapes.
Having that in mind, we want to design a system that is able to count how many tapes will be required to store the backup in the most efficient way.
The parameter of your function will be a structure that will contain the file sizes and the capacity of the tapes.
You must return the minimum amount of tapes required to store the files.

You can write any methods or classes you would like. However, all new classes must be written in this
file and you cannot change the BackupSystem class name, the Batch interface contract or the getMinimumTapeCount() method signature.

Example:
--------
	Input: Tape Size = 100; Files: 70, 10, 20
	Output: 2
*/

import java.util.Arrays;

/**
 * Created by fagracas on 01/18/2017.
 */

public class BackupSystem {

    public interface Batch {
        int[] getFileSizes();
        int getTapeSize();
    }

    public static class BatchImpl implements Batch
    {
        public final int[] getFileSizes()
        {
            return new int[] { 70, 10, 20};
        }

        public final int getTapeSize()
        {
            return 100;
        }
    }

    public static class BatchImpl2 implements Batch
    {
        public final int[] getFileSizes()
        {
            return new int[] { 100, 100, 20};
        }

        public final int getTapeSize()
        {
            return 100;
        }
    }

    public static class BatchImpl3 implements Batch
    {
        public final int[] getFileSizes()
        {
            return new int[] { 100, 100, 100, 40, 40, 40};
        }

        public final int getTapeSize()
        {
            return 100;
        }
    }

    public int getMinimumTapeCount(final Batch batch)
    {
        int[] fileSizes = batch.getFileSizes();
        int tapeSize = batch.getTapeSize();

        Arrays.sort(fileSizes);
        int count = 0;

        for (int low = 0, high = fileSizes.length - 1; low <= high; )
        {
            if (fileSizes[high] + fileSizes[low] <= tapeSize)
                low++;

            high--;
            count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        BackupSystem bs = new BackupSystem();
        Batch batch = new BatchImpl();
        Batch batch2 = new BatchImpl2();
        Batch batch3 = new BatchImpl3();

        //int result = bs.getMinimumTapeCount(batch);
        //int result2 = bs.getMinimumTapeCount(batch2);
        int result3 = bs.getMinimumTapeCount(batch3);

        //System.out.println(result);
        //System.out.println(result2);
        System.out.println(result3);
    }
}
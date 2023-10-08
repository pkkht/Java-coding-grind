package com.coding.exercises;

import java.io.*;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.stream.Collectors.joining;

class RepeatedStringResult {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here

        long remainder = n % s.length();
        long stringRepeatTimes = n / s.length();
        long frequency = 0;
        long restFrequency = 0;

        //Calculate the frequency of letter 'a' each str.
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') frequency++;
        }

        //Calculate the frequency of the remaining letters.
        for(int i = 0; i < remainder; i++) {
            if(s.charAt(i) == 'a') restFrequency++;
        }

        //Return the number occurrence of 'a' in th infinite str.
        return (stringRepeatTimes * frequency) + restFrequency;
    }

}

public class RepeatedStringResultSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = RepeatedStringResult.repeatedString(s, n);

        System.out.println(result);


        bufferedReader.close();
    }
}

package com.coding.exercises;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 *
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
class EqualizeTheArrayResult {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
        // Write your code here
        int maxCount = 0;
        HashMap<Integer,Integer> counts = new HashMap<>();
        for( Integer i : arr ) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> pair: counts.entrySet()) {
            if (pair.getValue() > maxCount) {
                maxCount = pair.getValue();
            }
        }
        return arr.size() - maxCount;
    }

}

public class EqualizeTheArraySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = EqualizeTheArrayResult.equalizeArray(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}

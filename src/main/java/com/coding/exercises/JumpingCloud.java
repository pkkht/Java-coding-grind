package com.coding.exercises;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

class JumpingCloudResult {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int position = 0;
        int jumps = 1;
        int n = c.size();

        while(position < n - 1) {
            //Jump out the clouds
            if(position + 2 >= n - 1) {
                break;
                //Move to the next to step if it's good
            } else if(c.get(position + 2) == 0) {
                position = position + 2;
                //Otherwise
            } else position++;
            jumps++;
        }

        return jumps;
    }

}

public class JumpingCloud {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = JumpingCloudResult.jumpingOnClouds(c);

        System.out.println(result);
        bufferedReader.close();

    }
}


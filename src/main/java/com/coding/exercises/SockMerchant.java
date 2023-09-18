package com.coding.exercises;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result {
   // https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

    public static int sockMerchant(List<Integer> ar) {
       Long count = 0l;
       count = ar.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .filter(m -> m.getValue() > 1).map(Map.Entry::getValue).reduce(0l, (a,b) -> (a+ (b/2)));
        return count.intValue();
    }

}

public class SockMerchant {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(ar);

        bufferedReader.close();
        System.out.println(result);
    }
}


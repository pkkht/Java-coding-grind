package com.coding.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
 */
class SumResult {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int leftDiagSum =0;
        int rightDiagSum = 0;

        leftDiagSum = getDiagonalSum(arr);

        for(List<Integer> iList :arr){
            Collections.reverse(iList);
        }

        rightDiagSum = getDiagonalSum(arr);

        System.out.println(leftDiagSum);
        System.out.println(rightDiagSum);
        return Math.abs(leftDiagSum-rightDiagSum);
    }

    private static int getDiagonalSum(List<List<Integer>> arr){
        int diagSum = 0;
        for(int i =0; i < arr.size(); i++){
            diagSum += arr.get(i).get(i);
        }
        return diagSum;
    }
}

public class DifferenceOfDiagonalSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = SumResult.diagonalDifference(arr);


        bufferedReader.close();

    }
}

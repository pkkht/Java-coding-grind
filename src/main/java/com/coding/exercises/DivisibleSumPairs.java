package com.coding.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;


/**
 *
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
class Result {


    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

       List<DivisibleSumPair> dspList = new ArrayList<>();
       for(int i=0; i<ar.size()-1; i++){
           for(int j=i+1; j < ar.size() ; j++) {
               DivisibleSumPair dsp = new DivisibleSumPair(ar.get(i), ar.get(j), k);
               dspList.add(dsp);
           }
       }

        dspList.forEach(dsp -> System.out.println(dsp.toString()));
        return dspList.stream().filter(dsp -> dsp.isDivisibleSum==true).collect(toList()).size();

    }
}


class DivisibleSumPair{
    public DivisibleSumPair(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.isDivisibleSum = (this.x + this.y)%k == 0;
    }

    public boolean isDivisibleSum() {
        return isDivisibleSum;
    }

    public void setDivisibleSum(boolean divisibleSum) {
        isDivisibleSum = divisibleSum;
    }

    boolean isDivisibleSum;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int y;

    @Override
    public String toString() {
        return "DivisibleSumPair{" +
                "isDivisibleSum=" + isDivisibleSum +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

public class DivisibleSumPairs {
    public static void main(String[] args) throws  IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);
        System.out.println(result);
        bufferedReader.close();
    }
}

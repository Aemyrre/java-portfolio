package test;

import main.Q1TwoSum;

import java.util.Arrays;

public class Q1TwoSumTestClass {

    private Q1TwoSum twoSum;

    public static void main(String[] args){
        Q1TwoSumTestClass test = new Q1TwoSumTestClass();
        test.runTwoSum();
    }

    void runTwoSum() {
        int[] nums = new int[]{
                -1,-2,-3,-4,-5
        };
        int target = -8;
        twoSum = new Q1TwoSum(nums, target);
        int[] numbers = twoSum.twoSum();
        System.out.println(Arrays.toString(numbers));
    }

}

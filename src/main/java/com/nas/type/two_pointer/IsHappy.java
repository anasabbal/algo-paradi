package com.nas.type.two_pointer;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    /**
     * Determines if a number is a happy number.
     *
     * @param n the number to check
     * @return true if the number is a happy number, false otherwise
     */
    public boolean isHappy(int n){
        Set<Integer> seen = new HashSet<>(); // create a set to track seen numbers

        while (n != 1 && !seen.contains(n)) { // loop until n equals 1 or a cycle is detected
            seen.add(n); // add the current number to the set of seen numbers
            n = getSumOfSquares(n); // update n to the sum of the squares of its digits
        }

        return n == 1; // return true if n equals 1, indicating a happy number
    }

    /**
     * Calculates the sum of the squares of the digits of a number.
     *
     * @param num the number whose digits will be squared and summed
     * @return the sum of the squares of the digits
     */
    private int getSumOfSquares(int num) {
        int sum = 0; // initialize the sum to 0

        while (num > 0) { // loop until the number becomes 0
            int digit = num % 10; // get the last digit of the number
            sum += digit * digit; // add the square of the digit to the sum
            num /= 10; // remove the last digit from the number
        }

        return sum; // return the sum of the squares of the digits
    }

    public static void main(String[] args) {
        IsHappy solution = new IsHappy();

        // Example 1: Happy number
        int n1 = 19;
        System.out.println(solution.isHappy(n1));  // Output: true

        // Example 2: Not a happy number
        int n2 = 2;
        System.out.println(solution.isHappy(n2));  // Output: false
    }
}

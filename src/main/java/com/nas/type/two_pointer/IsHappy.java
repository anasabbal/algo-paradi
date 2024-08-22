package com.nas.type.two_pointer;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n){
        Set<Integer> seen = new HashSet<>();

        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }
    private int getSumOfSquares(int num) {
        int sum = 0;

        while (num > 0){
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
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

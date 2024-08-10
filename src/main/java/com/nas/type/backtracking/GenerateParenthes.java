package com.nas.type.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthes {

    /**
     * Generates all combinations of well-formed parentheses.
     *
     * @param n the number of pairs of parentheses
     * @return a list of strings, where each string is a valid combination of parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    /**
     * Uses backtracking to generate well-formed parentheses combinations.
     *
     * @param current the current combination of parentheses being built
     * @param open the number of opening parentheses used so far
     * @param close the number of closing parentheses used so far
     * @param max the maximum number of pairs of parentheses (equal to n)
     * @param result the list to store all valid combinations
     */
    private void backtrack(String current, int open, int close, int max, List<String> result){
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }
        if(open < max){
            backtrack(current + "(", open + 1, close, max, result);
        }
        if (close < open) {
            backtrack(current + ")", open, close + 1, max, result);
        }
    }
    
    public static void main(String[] args) {
        GenerateParenthes pg = new GenerateParenthes();
        System.out.println(pg.generateParenthesis(3));
        System.out.println(pg.generateParenthesis(1));
        System.out.println(pg.generateParenthesis(4));
    }
}

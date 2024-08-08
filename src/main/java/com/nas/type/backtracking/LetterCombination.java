package com.nas.type.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    private static final Map<Character, String> phoneMap = new HashMap<>();
    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }
    /**
     * Generates all possible letter combinations that the input digits could represent.
     *
     * @param digits a string of digits (2-9) to generate letter combinations for
     * @return a list of strings, where each string is a combination of letters
     *         corresponding to the input digits
     */
    public static List<String> letterCombinations(String digits){
        List<String> results = new ArrayList<>();
        if(digits == null && digits.length() <= 0){
            return results;
        }
        backtrack(digits, 0, new StringBuilder(), results);
        return results;
    }

    /**
     * Uses backtracking to generate letter combinations for the input digits.
     *
     * @param digits the string of digits (2-9) to generate combinations for
     * @param index the current index in the digits string being processed
     * @param currentCombination the current combination of letters being built
     * @param result the list to store all generated combinations
     */
    private static void backtrack(String digits, int index, StringBuilder currentCombination, List<String> result){
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(digits, index + 1, currentCombination, result);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}

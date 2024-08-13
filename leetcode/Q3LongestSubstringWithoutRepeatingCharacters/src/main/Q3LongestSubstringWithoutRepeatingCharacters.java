package main;

import java.util.ArrayList;
import java.util.Arrays;

public record Q3LongestSubstringWithoutRepeatingCharacters(String word) {

    public void countSubstring() {
        char[] parsedWord = word.toLowerCase().toCharArray();
        ArrayList<Character> listOfChars = new ArrayList<>();

        for (char c : parsedWord) {
            listOfChars.add(c);
        }



        System.out.println(Arrays.toString(parsedWord));
        System.out.println(listOfChars.size());
        System.out.println(word.substring(0, 6));
    }
}

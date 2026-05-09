//Given a string s, reverse only all the vowels in the string and return it.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
//and upper cases, more than once.
//
//Example 1:
//Input: s = "IceCreAm"
//Output: "AceCreIm"
//Explanation:
//The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
//
//Example 2:
//Input: s = "leetcode"
//Output: "leotcede"
//
//Constraints:
//1 <= s.length <= 3 * 105
//s consist of printable ASCII characters.
package com.leetCode75.ArrayString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
       System.out.println(reverseVowels("IceCreAm"));
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("aeiou"));
        System.out.println(reverseVowels("aebic"));
        System.out.println(reverseVowels("bcdf"));
    }

    public static String reverseVowels(String s) {
        String[] strArr = s.split("");
        String vowels = "aeiouAEIOU";
        List<String> vowelsInWord = new ArrayList<>();
        for (String str : strArr) {
            if(vowels.contains(str)){
                vowelsInWord.add(str);
            }
        }
        if (vowelsInWord.isEmpty()){
            return s;
        }
        List<String> reversedVowelsInWord = new ArrayList<>(vowelsInWord);
        Collections.reverse(reversedVowelsInWord);

        int counter = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(vowelsInWord.get(counter))) {
                strArr[i] = reversedVowelsInWord.get(counter);
                counter++;
            }
            if (counter >= vowelsInWord.size()){
                return String.join("",strArr);
            }
        }
        return String.join("",strArr);
    }
}

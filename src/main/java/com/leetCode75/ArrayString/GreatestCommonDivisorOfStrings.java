//For two strings s and t, we say "t divides s" if
//and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
//
//Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
//
//Example 1:
//Input: str1 = "ABCABC", str2 = "ABC"
//Output: "ABC"
//
//Example 2:
//Input: str1 = "ABABAB", str2 = "ABAB"
//Output: "AB"
//
//Example 3:
//Input: str1 = "LEET", str2 = "CODE"
//Output: ""
//
//Example 4:
//Input: str1 = "AAAAAB", str2 = "AAA"
//Output: ""
//
//Constraints:
//1 <= str1.length, str2.length <= 1000
//str1 and str2 consist of English uppercase letters.
package com.leetCode75.ArrayString;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
        System.out.println(gcdOfStrings("AAAAAB", "AAA"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int minStr = Math.min(str1.length(), str2.length());
        for (int i = minStr; i > 0; i--) {
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                return str1.substring(0, i);
            }
        }
        return "";
    }
}

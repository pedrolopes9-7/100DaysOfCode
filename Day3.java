package com.sigma.dsalgo.factory;

public class Day3 {
    public static boolean isPalindrome(String string) {
        //Naive solution using String concatenation to reverse
        //the original String and apply equals to check if they
        //are the same.

        //Time complexity: Even if it looks like this algorithm is
        //O(n) due to one single for loop, in fact it is O(x * n^2),
        //where x is the size of the copy crated by concatenation

        //This happens because of the String concatenation used
        //inside the for loop. String concatenation in Java will
        //generate a new String object for every concatenation.
        //Meaning that, all strings will be copied over, character
        //character, for copies of size x.

        //Thus, the time complexity is something like:
        //O(x + 2x + 3x + ... + nx) -> O(x * n^2)
        //where n is the number of iterations
        //and x is the size of the copied string object

        //The space complexity is O(n) because of the reversed string
        //object that, at the worst case, will have size n
        String reversedString = "";

        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString += string.charAt(i);
        }

        return string.equals(reversedString);
    }

    public static boolean isPalindromeStringBuilder(String string) {
        //A simple fix in the naive algorithm optimizes our code a lot
        //Instead of using a String type, we can use a StringBuilder
        //that is a resizable array of Strings, and when necessary
        //we can get the String using toString method

        //Time complexity: O(n) due to single for-loop and because
        //no extra strings are created
        //Space complexity: O(n) due to size of the StringBuilder that
        //is n in the worst case
        StringBuilder reversedString = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }

        return string.equals(reversedString.toString());
    }

    public static boolean isPalindromeNoSpace(String str) {
        //Most optimized solution for the problem, but could be a little trickier
        //to implement. In this algorithm we keep two pointers, one that beginning
        //of the String, and another at the end.
        //We iterate over the string characters, comparing the character at the begin
        //pointer with the character at the end pointer. We keep doing that, until we
        //have different characters in those positions, and returns false. Otherwise,
        //we return true, and the String is a palindrome.

        //Time complexity: One single for-loop of size n, leading to O(n)
        //Space complexity: O(1) because no new objects of size n were created
        boolean isPalindrome = false;
        int endPtr = str.length() - 1;

        if (str.length() == 1) {
            return true;
        }

        for (int beginPtr = 0; beginPtr < str.length(); beginPtr++) {
            if (str.charAt(beginPtr) == str.charAt(endPtr)) {
                isPalindrome = true;
                endPtr--;
            }else {
                return false;
            }
        }
        return isPalindrome;
    }
}

import java.util.HashMap;
import java.util.Map;

//Problem: Find the index of the first character in the String that doesn't repeat
//Example: input string = 'banana', 'b' is the first non-repeating letter in this string
//Another example: 'cccaaaddef', 'e' is the first non-repeating letter in this string

//Solution: Keep a map with all the frequencies for each letter in the string.
//Then, read the string and lookup the map. The first letter that you find in the map with frequency equals to 1,
//is the answer for this question.

//Time complexity: Runs in O(n) time. Two non-nested loops of size 'n'.
//Space complexity: Depends on the alphabet. If they are simply english lowercase alphabet (26 letters), this is constant space (O(1)).
//The alphabet can ben Unicode, ASC-II, etc. that are bigger alphabets, leading to a bigger map.
//To be more precise, we can say that this is O(d) space, where 'd' is the size of the alphabet

public class Day11 {
    public int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> letterFrequency = new HashMap<>();

        updateLetterFrequencies(string, letterFrequency);

        return getFirstNonRepeatingLetter(string, letterFrequency);
    }

    private int getFirstNonRepeatingLetter(String string, Map<Character, Integer> letterFrequency) {
        for (int i = 0; i < string.length(); i++) {
            if (letterFrequency.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    private void updateLetterFrequencies(String string, Map<Character, Integer> letterFrequency) {
        for (int i = 0; i < string.length(); i++) {
            Character currentLetter = string.charAt(i);

            letterFrequency.put(currentLetter, letterFrequency.getOrDefault(currentLetter, 0) + 1);
        }
    }
}

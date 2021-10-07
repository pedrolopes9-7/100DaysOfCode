public class Day18 {
    //Problem Statement: Encrypt an input string and return a new encrypted String using the Caesar's Cypher Encryptor.
    //Caesar's Cypher Encryptor takes the String and a factor and moves every letter forward 'f' times in the alphabet,
    //where 'f' is the factor.
    //Example: String="abc", f=2. encrypted="cde"
    //         String="xyz", f=2. encrypted="zab"
    //Solution: Define an alphabet (consider the english alphabet for simplicity). Then, for each letter of the input string
    //encrypt the current letter index by shifting it by 'f' positions in the alphabet. To not go out of bounds, you'll need to mod the result
    //by 26 (the size of the alphabet).

    //Time complexity: O(n). We simply iterate over n chars of the string. The size of the alphabet doesn't matter here, because
    //getting an specific index in any alphabet is O(1).

    //Space complexity: We use 'n' chars to store the encrypted string + 26 letters for the english alphabet. Therefore, it's:
    //O(n) + O(1) = O(n). Note that, if your alphabet could be bigger than the input string, you'll need to consider that too.
    //So, a more realistic space complexity notation would be: O(n + k), where n is the size of the string and k is the size
    //of the alphabet. We pick the biggest.

    public static String encrypt(String toEncrypt, int factor) {
        //Strings are immutable in java. So, the best way is to use a auxiliary char array and create a new string from it
        char[] encrypted = new char[toEncrypt.length()];

        for (int i = 0; i < toEncrypt.length(); i++) {
            encrypted[i] = encryptLetter(toEncrypt.charAt(i), factor);
        }

        return new String(encrypted);
    }

    private static char encryptLetter(char letterIndex, int factor) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        int newLetterIndex = alphabet.indexOf(letterIndex) + factor;

        return alphabet.charAt(newLetterIndex % 26);
    }
}



import java.util.HashSet;
import java.util.Set;

public class Day20 {

    //Problem Statement: Find the first duplicated value in a array of numbers. Note: You're not allowed to mutate/sort the order of the input array.
    //For instance - if the array is [0 9 2 3 1 0 2 2], the answer should be 0 that is the first number that is repeated.
    //Strategy 1: Keep a map of the visited numbers and return the first number in the array that exists in the map.
    //Time complexity: Iterate through all elements once. That leads to O(n) in time.
    //Space complexity: Auxiliary map at the worst case will hold 'n' elements. Thus it is O(n) in space too.

    public int findDuplicatedValueWithMap(int[] array) {
        Set<Integer> repeatTimes = new HashSet<>();

        for (int current : array) {
            if (repeatTimes.contains(current)) {
                return current;
            }
            repeatTimes.add(current);
        }
        //returns -1 if can't found anything
        return -1;
    }

    //Strategy 2: Instead of adding in a map if a element was visited, you can multiply the value at index  (current number - 1)
    //Since the same value minus 1 will always generate the same index, that means if we encounter one negative value in that index, we've found our element.
    //Note that: in order for this solution work, all the elements in the array should be greater than 0.
    //Time complexity: O(n). At the end you can transform back your array to its original state by multiplying everything by -1 in O(n) time
    //Space complexity: No auxiliary space needed, so it is O(1) in space.

    public int firstDuplicateValueWithNegatives(int[] array) {
        for (int current : array) {
            int currentAbsoluteValue = Math.abs(current);

            if (array[currentAbsoluteValue - 1] < 0) {
                return currentAbsoluteValue;
            }
            array[currentAbsoluteValue - 1] = array[currentAbsoluteValue - 1] * (-1);
        }

        return -1;
    }
}

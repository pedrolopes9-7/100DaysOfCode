import java.util.Collections;
import java.util.List;

//Problem Statement - You're given an array of integers and one target. Your job is to
//move to the end of the array all elements that are equal to the given target.
//e.g, you're given the array [3 2 5 2 4 1 2 3 1 2], with target=2. The output should be
//[3 5 4 1 3 1 2 2 2 2].

//Solution: keep two pointers, one at the beginning and another at end of your array.
//1 - Iterate over the elements, while beginPtr is less than endPtr. (1st while loop)
//2 - Compare the current element with your target:
//    if they are the same, you need to:
//       you keep moving your endPtr to the left, until values beginPtr and endPtr are different. (2nd while loop)
//       Because we don't want to mess with the already swapped elements
//       When you get the correct endPtr, you swap it with the current number
//    else:
//       you just continue iterating

//Time complexity: The algorithm runs in O(n) time. The analysis here can be misleading, due to the nested loops.
//But, in fact, if one loop runs n times, then by consequence the other loop will run in constant time.
//For instance, if all the elements in the array are equals to the target, then the 1st loop will run 1 time
//and the second loop n times. In the other hand, if there's just one element equals to the target, the second loop
//will run just once, and the first will run n times. One loop complement the other.

//Space complexity: O(1), no extra memory needed. All operations are done in place.
public class Day7 {
    public static List<Integer> moveTargetToEnd(List<Integer> array, int target) {

        int beginPtr = 0;
        int endPtr = array.size() - 1;

        while (beginPtr < endPtr) {
            if (array.get(beginPtr) == target) {
                while (array.get(beginPtr).equals(array.get(endPtr))) {
                    endPtr--;
                }
                Collections.swap(array, beginPtr, endPtr);
            }
            beginPtr++;
        }
        return array;
    }
}

class Day15 {
    //Problem Statement: Check if a circular array contains a single cycle.
    //A circular array is an array that every element represents a jump to the next index.
    //For negative values it jumps to left, and for positive values it jumps to right.
    //If a jump is out of bounds of the array, it wraps over to the other side.
    //Example: array=[1 -2 5]: you read array[0]=1, then you jump 1 position to right, landing at array[1]=-2
    //                         you read array[1]=-2, then you jump 2 positions to left, landing at array[2]=5
    //                         you read array[2]=5, then you jump 5 positions to right, landing at array[1]=-2
    //A single cycle occurs if, starting at any index and following the jumps, every element is visited only once before
    //landing back at the start index.

    //Solution: 2 steps:
    //  1- Write a function that gets the next element in this kind of array: Sum the index with the value in it
    //      and mod with the size of the array. That way, your next elements will not go out of bounds.
    //  2- Check a single cycle by simply iterating to the next, until you visited exactly once the elements in your array.
    //     Then, check if the latest element got from getNext is the starting element, in your case was index=0. If so,
    //     it has a single check, otherwise it doesn't

    //Time Complexity: In the worst case, this algorithm runs 'n' times where n is the size of the array.
    //Also, the method getNext is a simple arithmetic calculation, and thus it is O(1). Therefore, the overall complexity is O(n).
    //Space Complexity: It doesn't use any additional memory and there's no recursive calls. Therefore, it's O(1)
    public static boolean hasSingleCycle(int[] array) {

        int inCycle = 0;
        int nextIndex = 0;

        while (inCycle < array.length) {
            //edge case for 0 in the first position. If we did one jump and the next index
            //remains zero, it fails fast.
            if (inCycle > 0 && nextIndex == 0) {
                return false;
            }

            nextIndex = getNext(array, nextIndex);
            inCycle++;
        }

        return nextIndex == 0;
    }

    private static int getNext(int[] array, int i) {
        int next = (i + array[i]) % array.length;

        //Handle negative indexes by adding the size of the input array.
        //Example: i=-4, array[i]=2, array.length=4 => next = -4 + 2 % 4 = -2.
        //To correct that we calculate next= -2 + 4 = 2. Thus, next index is 2.
        if (next >= 0) {
            return next;
        }
        else {
            return next + array.length;
        }
    }
}

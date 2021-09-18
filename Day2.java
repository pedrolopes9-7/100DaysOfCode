package com.sigma.dsalgo.factory;

class Day2 {
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    //In binary search, we keep dividing the original array and calling the same
    //function recursively in the half that the target is likely to be.

    //Meaning:
    //1 - if the target is equal to the element in the middle position of the array,
    //we've found our element.
    //2 - Else, if the target is lesser than the middle element
    //we search in the left side of the array.
    //3 - In last case, if the target is greater than
    //the middle element, we search in the right side of the array.
    //4 - If we don't find the target (or left pointer passed right pointer), we return -1

    //Time complexity: This algorithm runs in O(log n) time because we're always searching
    //in halves of the original array.
    //Space complexity: Uses O(log n) time due to the size of the heap during the recursive
    //calls

    private static int binarySearch(int[] array, int target, int left, int right){
        if (left > right){
            return -1;
        }

        int middle = (left + right) / 2;

        if (target == array[middle]) {
            return middle;
        }
        else if (target < array[middle]){
            return binarySearch(array, target, left, middle - 1);
        }
        else {
            return binarySearch(array, target, middle + 1, right);
        }
    }
}

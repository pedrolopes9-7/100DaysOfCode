public class Day19 {
    //Problem Statement: Classic problem to find the longest peak in a array. A peak is defined as adjacent integers that the elements are strictly smaller until
    //they reach a tip (the highest value). Then, all the values after the tip are strictly decreasing.
    //Example: In array [-3 -2 -1 6 4 3 2 1 5 3] the longest peak has size=8, and its peak element is 6. But, there are other peaks in there with smaller size:
    //[-3 -2 -1] is a peak. [1 5 3] is a peak. [-3 -2 -1 6 4] is a peak. But, we're interested only in the longest peak of size=8

    //Solution: Keep iterating over the elements, finding for peaks. If the element is not a peak, you can ignore it. Otherwise, if the element is a peak we need
    //to make three calculations: 1) calculate the size of the peak from the current index to the leftmost index of this peak
    //                            2) calculate the size of the peak from the current index to the rightmost index of this peak
    //                            3) calculate the total size of the current peak, and compare with the longest peak found so far, and update it accordingly.
    //Update the current index to be the rightmost index of previous peak, to not make duplicate calculations. At the end, returns the longest peak found.
    //Time complexity: Since we're not making duplicate calculations due to the jump to the rightmost index, the loop will run at most 'n' times. Thus, it's O(n)
    //Space complexity: We don't use any auxiliary space here, except for variables. Thus, it's O(1).
    public static int longestPeak(int[] array) {
        int currentIndex = 1; int longestPeakFound = 0;

        while (currentIndex < array.length - 1) {
            if (!isPeak(array, currentIndex)) {
                currentIndex++; continue;
            }

            int leftmostPeakIndex = getPeakLeftmostIndex(array, currentIndex);
            int rightMostPeakIndex = getPeakRightmostIndex(array, currentIndex);
            int currentPeak = rightMostPeakIndex - leftmostPeakIndex - 1;

            if (currentPeak > longestPeakFound) {
                longestPeakFound = currentPeak;
            }
            currentIndex = rightMostPeakIndex;
        }

        return longestPeakFound;
    }

    private static boolean isPeak(int[] array, int currentIndex) {
        return array[currentIndex - 1] < array[currentIndex] && array[currentIndex + 1] < array[currentIndex];
    }

    private static int getPeakLeftmostIndex(int[] array, int currentIndex) {
        int leftIndex = currentIndex - 2;

        while (leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]){
            leftIndex--;
        }

        return leftIndex;
    }

    private static int getPeakRightmostIndex(int[] array, int currentIndex) {
        int rightIndex = currentIndex + 2;

        while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
            rightIndex++;
        }

        return rightIndex;
    }
}

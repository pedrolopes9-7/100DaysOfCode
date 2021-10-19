public class Day21 {
    //Problem statement: Search for a specific number in a sorted (for both rows and cols) matrix, and return its row and col indexes.
    //Example: A sorted matrix matrix is like [1, 2, 5]
    //                                        [3, 4, 7]
    //                                        [6, 8, 9]
    //The naive solution is obvious: you just iterate over all elements and return when found. This solution is O(n^2), thus not so good.
    //Optimal solution: We can take advantage of the fact that the matrix is sorted, and traverse it in a more smart way.
    //This algorithm is something like a binary search for 2-D arrays. You go to left if target is smaller than the current element, to the right
    //if the target is bigger or if it is equal you return the element. In last case, you return a pair of -1's.
    //Keep in mind that

    //Time complexity: At the worst case this algorithm will search in a entire column or in a entire row.
    //Thus, it's O(N + M) - N is the number of row, M is the number of columns.
    //Space complexity: We don't store any additional space, leading to O(1)
    public static Pair search(int[][] matrix, int target) {

        int currentRow = 0;
        int currentCol = matrix[0].length - 1;

        while (currentRow < matrix.length && currentCol >= 0) {
            if (target == matrix[currentRow][currentCol]) {
                return new Pair(currentRow, currentCol);
            } else if (target < matrix[currentRow][currentCol]) {
                currentCol--;
            } else {
                currentRow++;
            }
        }
        return new Pair(-1, -1);
    }

    static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}

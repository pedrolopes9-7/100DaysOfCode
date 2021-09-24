//Problem statement: calculate the sum of all nodes depth in a binary tree.
//The depth is the "level" of that the node in the binary tree. Or more formally,
//it is the distance between the current node and the root node of the tree.
//Example:
//          4         -> depth 0
//        /   \
//       3     1      -> depth 1
//      / \   / \
//     2  7  5  10    -> depth 2

//sum of all depths: 2 + 2 + 2 + 2 + 1 + 1 + 0 = 10

//Solution: you can solve this question with a Pre Order traversal, keeping
//track of the currentDepth of that node, and incrementing one on it whenever
//you jump to the left or the right subtree. At the end, the recursive calls
//will add up to the sum of all currentDepths for all nodes in the tree.

//Time complexity: We visit each node exactly once, so the algorithm is O(n) time
//Space complexity: We don's use extra space besides the recursive calls. The algorithm
//will at least "h" number of stacked recursive calls, where "h" is the height of this tree.
//Therefore, it is O(h) for space

public class Day10 {
    public int calculateNodeDepthSum(BinaryTree root) {
        return calculateNodeDepthSum(root, 0);
    }

    private int calculateNodeDepthSum(BinaryTree node, int currentDepth) {
        if (node == null) {
            return 0;
        }

        return currentDepth +
                calculateNodeDepthSum(node.left, currentDepth + 1) +
                calculateNodeDepthSum(node.right, currentDepth + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}




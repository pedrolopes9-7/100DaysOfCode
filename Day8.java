public class Day8 {
    //Problem statement: Check if a given binary tree is a binary search tree.
    //A binary search tree keeps the binary search property. In other words, for any
    //given node in the three:
    // - its value is lesser than or equal to all the node values in the right subtree
    // - its value is greater than all the node values in the left subtree
    //Example:
    // This is a invalid binary search tree   |  This is a valid binary search tree
    //              5                                           5
    //            /   \                                        /  \
    //           4     8                                      4    8
    //          / \  /   \                                  /  \  /  \
    //         3  9  7    3                                2   3  7  15
    //Solution:
    //We keep track of the min and max values found so far for that given node.
    //Then, using recursion, we traverse the tree.
    // - if the current node is greater than or equal to the max value found so far, then its not valid
    // - if the current node is lesser than the min value found so far, the its also invalid

    //We perform an update in the max value and min value, using the function parameters of the recursive calls.
    //The max value for the left subtree will be the current node value, because all the lefts must be lesser than the current.
    //Same for the min value. The min value for the right subtree will be the current node, since all the rights must be greater than the current

    //Time complexity: The recursion is traversing the tree n times, leading to O(n) time
    //Space complexity: The recursion will start resolving the function calls in the stack when it
    //reaches a leaf node. So, the stack will never keeps more than "h" recursive calls,
    // where "h" is the height of the tree. Thus, the space needed is O(h)

    public boolean validate(BinaryTree tree) {
        return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(BinaryTree tree, int minValue, int maxValue) {

        if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        }
        if (tree.left != null && !validate(tree.left, minValue, tree.value)){
            return false;
        }
        return tree.right == null || validate(tree.right, tree.value, maxValue);
    }
}

class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
    }
}



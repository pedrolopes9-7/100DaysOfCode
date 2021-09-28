public class Day12 {

    //Problem statement: The infamous "Invert a Binary Tree". Given a Binary Tree, you should invert
    //its left and right nodes, for each node.
    //Example:
    //  (original tree)            (inverted tree)
    //       5                            5
    //     /   \                        /   \
    //    4     3     ------->        3      4
    //  /   \  /  \                 /   \   /  \
    // 2    1  5   8               1    2  8    5
    //Solution: The problem look like very difficult, but in fact, this is one of the simplest algorithms
    //in binary trees. While traversing the tree in either pre-order or post-order (in-order doesn't work),
    //swap the left with the right.
    //Time complexity - The same as a pre-order, post-order complexity -> O(n). The swap operation is O(1).
    //Space complexity - You'll have at most 'h' recursive calls,where 'h' is the height of the tree. Therefore,
    //this algorithm has O(h) space complexity
    public void invert(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        //swap(tree) could also be here
        invert(tree.left);
        invert(tree.right);
        swap(tree);
    }

    private void swap(BinaryTree tree) {
        BinaryTree leftAddress = tree.left;
        tree.left = tree.right;
        tree.right = leftAddress;
    }
}




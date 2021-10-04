//Problem Statement: Find the successor of a particular element in a binary tree. The successor of a node is
//the next element of it while traversing in a in-order fashion. In this example we're going to use a special case
//of binary tree where each node also keeps the pointer to its parent node. Note that this tree is not necessarily
//a Binary Search Tree.
//Example of a successor node:
//             6
//           /    \              in-order traversal: [7 -> 4 -> 8 -> 6 -> 7 -> 19 -> 15]
//         4       19            successor of 4 is 8. successor of 7 is 19, etc.
//       /   \    /  \
//      7     8  7    15

//Naive-Solution: Do the in-order traversal normally and store the elements in a auxiliary list. Find in that list
//the target element and get the next one, that's the answer. Uses O(n) time and O(n) space, because you need to visit all nodes in
//the in-order list of size n. To optimize that algorithm, we need to get rid of that auxiliary space and make the
//operations in place.

//Optimal solution (implemented one): The successor of a particular node in a in-order traversal is either:
//  - The left most child of its right sub-tree, if its right sub-tree is not null:
//     -> To find it, keep going to left of its right subtree until you land in a leaf node. That leaf node is your answer.
//  - If right subtree is null, that means the in order will go up, to its right most parent:
//     -> To find it, keep going up to its parents nodes while that nodes are coming from its parent right subtree.

//Time complexity: O(h), where 'h' is the height of that tree. We visit at most 'h' nodes of that tree, until we
//land at either the leaf node or the root node.
//Space complexity: O(1) no space needed and no recursion

public class Day16 {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) {
            return leftmostChild(node.right);
        }

        return rightmostParent(node);
    }

    private BinaryTree leftmostChild(BinaryTree node) {
        BinaryTree current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    private BinaryTree rightmostParent(BinaryTree node) {
        BinaryTree current = node;

        while (current.parent != null && current.parent.right == current) {
            current = current.parent;
        }

        return current.parent;
    }
}

public class Day17 {
    //Problem Statement: Given a Binary Tree (not necessarily a Binary search Tree), calculate the sum from the root node depth of
    //all sub-trees to all the other nodes depths. The depth of a node is defined as the distance between it and the root node of the tree.
    // Let's take a look at a example:
    //depth=0          5           ->root node(5) sum= 10
    //              /     \
    //depth=1     2        4       ->root node(2) sum= 2, ->root node(4) sum= 2
    //          /   \    /   \
    //depth=2  1     5  6     8    ->leaf nodes sum=0, b'coz there's not child nodes.
    //The total depth sum for this tree is: sum(5) + sum(2) + sum(4) = 10 + 2 + 2 = 14.

    //Solution: The problem is to sum all the depths of all the nodes for all the subtrees of the original tree.
    //If you think about it for a while, you'll realize that for every single node in that tree, the total sum from its depth to all its
    //parents nodes depth, is incrementing by a factor equals to the current node depth.

    //For instance, if the current node depth is 1, then the total sum for that particular node would be: 1 + 0.
    //If depth=2, then sum=2 + 1 + 0. If depth=3, sum=3 + 2 + 1 + 0. For the Nth node, the total sum of its depth to all its parents nodes depth
    //is equal to sum= n + (n-1) + (n-2) + ... + 2 + 1 + 0. The formula for this sum is given by sum= (n * (n + 1)) / 2.
    //So, while traversing the tree, keep track of the current node sum calculated by the formula, and add it to the total sum.
    //When you're done traversing the tree, the totalDepthSum variable will contain the sum for the whole tree.

    //Time complexity: Traversing 'n' nodes while doing a simples and free arithmetic operation (O(1)). Thus, total complexity is O(n)
    //Space complexity; The recursion stack for this traversal, will hold at most 'h' function calls, where 'h' is the height of the tree.
    //Therefore, it uses O(h) space.

    public static int allNodesDepthSum(BinaryTree root) {
        //depth of the root node is 0
        return allNodesDepthSum(root, 0);
    }

    private static int allNodesDepthSum(BinaryTree binaryTree, int currentNodeDepth) {
        if (binaryTree == null) {
            return 0;
        }

        //formula of sum of the natural numbers from 1 to n, where 'n' is the current node depth.
        int totalDepthSum = (currentNodeDepth * (currentNodeDepth + 1)) / 2;

        //Keep traversing in a pre-order style
        return totalDepthSum + allNodesDepthSum(binaryTree.left, currentNodeDepth + 1)
                + allNodesDepthSum(binaryTree.right, currentNodeDepth + 1);
    }
}

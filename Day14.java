//Problem Statement: Find the K largest value in a Binary Search Tree, where 'k' is given as a input.
//Assume that 'k' is a valid integer, and thats less than or equal to the tree size''
//Example: K=5, and you tree is:
//             6                largest:             5th  4th  3rd  2nd  1st
//           /   \              Ordered tree: [2 3   4    6    7     8   15]
//         4      8             5-th largest is: 4
//       /   \   /  \
//      2    3  7    15
//Naive-Solution: You can simply do the inOrder traversal and get the elements of this tree sorted. Then,
//your Kth largest would be InOrderTraversalArray.size() - k. The solution is correct, but not optimal. It runs
//in O(n) time and uses O(h) space.

//Optimal Solution (The implemented one): We don't need to do the entire in order traversal. By traversing it from right to left,
//we are traversing in the reverse order. So we can stop it when we have reached 'k' visited values. The latest node visited when we 'k' is equals to
//the number of nodes visited, is the Kth largest node in our tree.
//To to do that I've used a Wrapper class to hold the 'latestNodeVisited' and 'numberOfNodesVisited' information. We keep traversing the tree
//from right to left, checking if 'numberOfNodesVisited' reached 'k'. If so, we return 'latestNodeVisited'. Otherwise, we keep traversing.

//The solution runs in O(h + k) time, where 'h' is the height of this tree. Value 'h' can be greater than 'k', that's why it appears here.
//Regarding space, the solution stills uses at least 'h' recursive calls, so thus it has O(h) space complexity.
class Day14 {

    public int findKLargestFrom(BinaryTree tree, int k) {
        NodesVisitedWrapper nodesVisitedWrapper = new NodesVisitedWrapper(0, -1);
        kInOrderTraversal(tree, k, nodesVisitedWrapper);
        return nodesVisitedWrapper.leastNodeVisited;
    }

    private void kInOrderTraversal(BinaryTree tree, int k, NodesVisitedWrapper nodesVisitedWrapper) {
        if (tree == null || nodesVisitedWrapper.numberOfNodesVisited >= k) {
            return;
        }

        kInOrderTraversal(tree.right, k, nodesVisitedWrapper);

        if (nodesVisitedWrapper.numberOfNodesVisited < k) {
            nodesVisitedWrapper.numberOfNodesVisited++;
            nodesVisitedWrapper.leastNodeVisited = tree.value;
            kInOrderTraversal(tree.left, k, nodesVisitedWrapper);
        }
    }

    static class NodesVisitedWrapper {
        public int numberOfNodesVisited;
        public int leastNodeVisited;

        NodesVisitedWrapper(int numberOfNodesVisited, int leastNodeVisited) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.leastNodeVisited = leastNodeVisited;
        }
    }
}
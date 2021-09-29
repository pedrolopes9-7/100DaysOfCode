import java.util.ArrayList;
import java.util.List;

public class Day13 {
    //Problem Statement: Given a binary tree, return a list of the sums of all the branches in a binary tree
    //A branch is a path from the root to a leaf node. Example:
    //          4                 branch 1: 4 -> 1 -> 3 - sum = 8
    //        /   \               branch 2: 4 -> 1 -> 5 - sum = 10
    //       1      6             branch 3: 4 -> 6 -> 7 - sum = 17
    //     /   \   /  \           branch 4: 4 -> 6 -> 10 - sum = 20
    //    3     5 7   10
    //Sum of all branches = [8, 10, 17, 20]
    //Resolution: By traversing your tree in a pre-order fashion, keep the current branch sum in a variable and
    //keep updating it with the value of the current node. If there's no more nodes at left or at right, that means
    //you're done with that particular branch and the result is added to the output list.

    public List<Integer> getBranchSums(BinaryTree root) {
        List<Integer> branchSums = new ArrayList<>();
        updateBranchSums(root, 0, branchSums);
        return branchSums;
    }

    private void updateBranchSums(BinaryTree root, int currentBranchSum, List<Integer> branchSums) {
        if (root == null) {
            return;
        }

        int branchSum = currentBranchSum + root.value;

        //if the following statement is true, that means your branch ended here
        if (root.left == null && root.right == null) {
            branchSums.add(branchSum);
            return;
        }

        updateBranchSums(root.left, branchSum, branchSums);
        updateBranchSums(root.right, branchSum, branchSums);
    }
}

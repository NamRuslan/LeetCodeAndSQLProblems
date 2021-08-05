package leetcode;

/**
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 *
 * The tilt of a tree node is the absolute difference between the sum
 * of all left subtree node values and all right subtree node values.
 * If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
 * The rule is similar if there the node does not have a right child.
 */
public class BinaryTreeTilt {

class Solution {
    public int findTilt(TreeNode root) {

        if (root == null) return 0;

        int[] res = new int[1];

        sumTilts(root, res);

        return res[0];
    }

    int sumTilts(TreeNode node, int[] sum) {

        int left, right;

        left = node.left != null ? sumTilts(node.left, sum) : 0;
        right = node.right != null ? sumTilts(node.right, sum) : 0;

        sum[0] += Math.abs(left - right);

        return left + right + node.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

}

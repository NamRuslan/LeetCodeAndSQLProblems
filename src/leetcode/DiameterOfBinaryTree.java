package leetcode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

static class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        findDiameter(root, res);
        return res[0];
    }

    int findDiameter(TreeNode node, int[] res) {

        int left = 0, right = 0;

        if (node.left != null) {
            left = findDiameter(node.left, res) + 1;
        }

        if (node.right != null) {
            right = findDiameter(node.right, res) + 1;
        }

        res[0] = Math.max(res[0], left + right);

        return Math.max(left, right);
    }
}

static class TreeNode {
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

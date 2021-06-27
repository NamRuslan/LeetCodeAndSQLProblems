package leetcode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
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
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            swapTreeNodes(root);
            return root;
        }

        public void swapTreeNodes(TreeNode node) {
            if (node == null) return;

            TreeNode buff = node.left;
            node.left = node.right;
            node.right = buff;

            swapTreeNodes(node.left);
            swapTreeNodes(node.right);
        }
    }
}

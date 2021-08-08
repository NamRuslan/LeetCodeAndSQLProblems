package leetcode;

/**
 * Given the root of a binary tree, construct a string consists of parenthesis and integers from
 * a binary tree with the preorder traversing way, and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship
 * between the string and the original binary tree.
 */
public class ConstructStringFromBinaryTree {
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverseTree(root, sb);
        return sb.toString();
    }

    void traverseTree(TreeNode node, StringBuilder s) {

        s.append(node.val);

        if (node.left != null) {
            s.append("(");
            traverseTree(node.left, s);
            s.append(")");

        } else if (node.right != null){
            s.append("()");
        }

        if (node.right != null) {
            s.append("(");
            traverseTree(node.right, s);
            s.append(")");
        }
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

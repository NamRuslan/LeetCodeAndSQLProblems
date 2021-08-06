package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is
 * a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this
 * node's descendants. The tree tree could also be considered as a subtree of itself.
 */
public class SubtreeOfAnotherTree {

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        boolean ans = true;
        List<TreeNode> list = new ArrayList<>();

        list = findEqualRoots(root, subRoot, list);

        if (list.isEmpty()) return false;

        for (TreeNode node : list) {
            ans = compareSubTrees(node, subRoot);
            if (ans) break;
        }

        return ans;
    }

    boolean compareSubTrees(TreeNode rootNode, TreeNode subRootNode) {

        if (rootNode == null && subRootNode == null) return true;
        if (rootNode == null ^ subRootNode == null) return false;
        if (rootNode.val != subRootNode.val) return false;

        return compareSubTrees(rootNode.left, subRootNode.left)
                && compareSubTrees(rootNode.right, subRootNode.right);
    }

    List<TreeNode> findEqualRoots(TreeNode rootNode, TreeNode subRoot, List<TreeNode> list) {

        if (rootNode.val == subRoot.val) list.add(rootNode);

        if (rootNode.left != null) findEqualRoots(rootNode.left, subRoot, list);
        if (rootNode.right != null) findEqualRoots(rootNode.right, subRoot, list);

        return list;
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

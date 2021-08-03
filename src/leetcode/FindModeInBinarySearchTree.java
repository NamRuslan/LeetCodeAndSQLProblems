package leetcode;

import java.util.*;

/**
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 */
public class FindModeInBinarySearchTree {

static class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max;

        max = countNodes(root, map);

        for (Integer i : map.keySet()) {
            if (map.get(i) == max) {
                list.add(i);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public int countNodes(TreeNode node, Map<Integer, Integer> map) {

        int i = 0, j = 0;

        if (map.containsKey(node.val)) {
            map.put(node.val, map.get(node.val) + 1);
        } else {
            map.put(node.val, 1);
        }

        if (node.left != null) i = countNodes(node.left, map);
        if (node.right != null) j = countNodes(node.right, map);

        i = Math.max(i, j);

        return Math.max(i, map.get(node.val));
    }
}

private class TreeNode {
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
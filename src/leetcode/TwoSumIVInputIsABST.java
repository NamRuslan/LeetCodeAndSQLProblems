package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class TwoSumIVInputIsABST {
static class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        traverseTree(map, root, k);
        for (Integer i : map.values()) {
            if (map.containsKey(i) && i * 2 != k) {
                return true;
            }
        }

        return false;
    }

    void traverseTree(Map<Integer, Integer> map, TreeNode node, int k) {
        map.put(node.val, k - node.val);
        if (node.left != null) {
            traverseTree(map, node.left, k);
        }
        if (node.right != null) {
            traverseTree(map, node.right, k);
        }
    }
}

/**
 * Improved solution (4ms -> 2ms)
 * There's no need to collect and check all elements
 */
class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetNode(root, set, k);
    }

    boolean findTargetNode(TreeNode node, Set<Integer> set, int k) {
        if (node == null) return false;
        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return findTargetNode(node.left, set, k) || findTargetNode(node.right, set, k);
    }
}

private static class TreeNode {
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

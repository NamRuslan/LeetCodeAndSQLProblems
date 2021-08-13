package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level
 * in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 */
public class AverageOfLevelsInBinaryTree {

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        collectNodeVals(root, map, 0);
        List<Double> res = new ArrayList<>();

        for (List<Integer> list : map.values()) {
            int count = 0;
            double sum = 0;
            for (Integer i : list) {
                sum += i;
                count++;
            }
            res.add(sum / count);
        }

        return res;
    }

    void collectNodeVals(TreeNode node, Map<Integer, List<Integer>> map, int level) {

        if (node == null) return;

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }

        map.get(level).add(node.val);

        collectNodeVals(node.left, map, level + 1);
        collectNodeVals(node.right, map, level + 1);
    }
}

/**
 * Improved runtime solution
 */
class Solution2 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        collectNodeVals(root, sum, count, 0);

        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }

        return sum;
    }

    void collectNodeVals(TreeNode node, List<Double> sum, List<Integer> count, int level) {

        if (node == null) {
            return;
        }

        if (sum.size() <= level) {
            sum.add((double) node.val);
            count.add(1);
        } else {
            sum.set(level, sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        }

        collectNodeVals(node.left, sum, count, level + 1);
        collectNodeVals(node.right, sum, count, level + 1);
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

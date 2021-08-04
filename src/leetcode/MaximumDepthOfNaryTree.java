package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfNaryTree {

class Solution {
    public int maxDepth(Node root) {

        if (root == null) return 0;
        int[] res = new int[1];
        findDepth(root.children, res);
        return res[0] + 1;
    }

    int findDepth(List<Node> nodes, int[] res) {

        List<Integer> list = new ArrayList<>();

        if (nodes.isEmpty()) {
            return 0;

        } else {
            for (Node node : nodes) {
                list.add(findDepth(node.children, res) + 1);
            }
        }

        int i = list.stream().max(Integer::compare).get();
        res[0] = Math.max(res[0], i);

        return i;

    }
}

class Solution2 {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int count = 1;
        List<Node> list = root.children;

        while (!list.isEmpty()) {
            count++;
            list = list.stream()
                    .filter(child -> child.children != null)
                    .map(node -> node.children)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }

        return count;
    }
}

class Solution3 {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int res = 0;

        for (Node node : root.children) {
            res = Math.max(maxDepth(node), res);
        }

        return res + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

}

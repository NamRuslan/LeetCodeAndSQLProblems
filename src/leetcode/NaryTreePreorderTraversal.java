package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 */
public class NaryTreePreorderTraversal {

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();

        addNode(root, ans);

        return ans;
    }

    void addNode(Node node, List<Integer> list) {

        if (node == null) return;

        list.add(node.val);

        for (Node child : node.children) {
            addNode(child, list);
        }
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

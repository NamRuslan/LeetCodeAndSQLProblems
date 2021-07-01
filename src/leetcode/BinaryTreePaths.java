package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 */
public class BinaryTreePaths {

     public class TreeNode {
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
        public List<String> binaryTreePaths(TreeNode root) {

            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            sb.append(root.val);

            if (root.left != null) addNode(list, sb, root.left);
            if (root.right != null) addNode(list, sb, root.right);
            if (root.left == null && root.right == null) list.add(String.valueOf(sb));


            return list;
        }

        private void addNode(List<String> list, StringBuilder sb, TreeNode node) {

            StringBuilder innerSb = new StringBuilder();

            innerSb.append(sb);
            innerSb.append("->");
            innerSb.append(node.val);

            if (node.left == null && node.right == null) {
                list.add(String.valueOf(innerSb));
            }

            if (node.left != null) {
                addNode(list, innerSb, node.left);
            }

            if (node.right != null) {
                addNode(list, innerSb, node.right);
            }

        }
    }

    /**
     * Improved solution (2ms -> 1ms)
     */
    class Solution2 {
        public List<String> binaryTreePaths(TreeNode root) {

            List<String> list = new ArrayList<>();
            String s = String.valueOf(root.val);

            if (root.left != null) addNode(list, s, root.left);
            if (root.right != null) addNode(list, s, root.right);

            if (root.left == null && root.right == null) list.add(s);

            return list;
        }

        private void addNode(List<String> list, String s, TreeNode node) {

            String innerS = s.concat("->").concat(String.valueOf(node.val));

            if (node.left == null && node.right == null) {
                list.add(innerS);
            }

            if (node.left != null) {
                addNode(list, innerS, node.left);
            }

            if (node.right != null) {
                addNode(list, innerS, node.right);
            }

        }
    }
}

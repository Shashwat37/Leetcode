/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode solve(int[] in, int[] post, int l, int r) {
        if (l > r) {
            return null;
        }

        int val = post[idx--];
        TreeNode root = new TreeNode(val);

        int mid = map.get(val);

        root.right = solve(in, post, mid + 1, r);
        root.left = solve(in, post, l, mid - 1);

        return root;
    }
}
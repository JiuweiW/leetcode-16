package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1038_BinarySearchTreetoGreaterSumTree {

    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        bstToGst(root.right);
        pre = root.val = pre + root.val;
        bstToGst(root.left);

        return root;
    }

    public TreeNode bstToGst2(TreeNode root) {

        List<TreeNode> data = new ArrayList<>();

        dfs(root, data);

        int sum = 0;
        for (int i = data.size() - 1; i >= 0; i--) {
            sum += data.get(i).val;
            data.get(i).val = sum;
        }
        return root;
    }

    private void dfs(TreeNode root, List<TreeNode> data) {
        if (root == null) return;

        dfs(root.left, data);
        data.add(root);
        dfs(root.right, data);

    }


    public static void main(String[] args) {

    }

}

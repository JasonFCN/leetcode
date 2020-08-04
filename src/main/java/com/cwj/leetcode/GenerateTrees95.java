package com.cwj.leetcode;

import java.util.List;

public class GenerateTrees95 {
    public static void main(String[] args) {
        
    }

    public static List<TreeNode> generateTrees(int n) {
        for (int i = 1; i <= n; i++) {
            // TreeNode node = new TreeNode(i);
        }
        return null;
    }

    public static void tet(int j ,int n){
        
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
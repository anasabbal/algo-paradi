package com.nas.type.binary;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    public static void main(String[] args) {
        InorderTraversal solution = new InorderTraversal();

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println(solution.inorderTraversal(root1));

        System.out.println(solution.inorderTraversal(null));

        TreeNode root3 = new TreeNode(1);
        System.out.println(solution.inorderTraversal(root3));
    }
}

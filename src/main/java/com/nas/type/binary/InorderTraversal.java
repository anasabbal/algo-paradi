package com.nas.type.binary;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    // performs inorder traversal and returns a list of node values
    public List<Integer> inorderTraversal(TreeNode root) {
        // create a list to store the result
        List<Integer> result = new ArrayList<>();
        // call the helper function to perform recursion
        inorderHelper(root, result);
        // return the final list of values
        return result;
    }

    // helper function to perform recursive inorder traversal
    private void inorderHelper(TreeNode node, List<Integer> result) {
        // base case: if the node is null, return
        if (node == null) {
            return;
        }
        // recursively traverse the left subtree
        inorderHelper(node.left, result);
        // add the current node's value to the result list
        result.add(node.val);
        // recursively traverse the right subtree
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

package cn.bigears.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution101
 * @author shenyang
 * @date 2020/6/8
 */
public class Solution101 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 两个list把每个深度上的node存起,再比较
     */
    private static boolean isSymmetricOne(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> listLeft = new LinkedList<>();
        listLeft.add(root.left);
        List<TreeNode> listRight = new LinkedList<>();
        listRight.add(root.right);

        TreeNode leftCurrent;
        TreeNode rightCurrent;
        int i = 0, current = 0;
        do {
            leftCurrent = listLeft.get(current);
            rightCurrent = listRight.get(current);
            if (leftCurrent == null && rightCurrent == null) {
                continue;
            }
            if (leftCurrent != null && rightCurrent == null) {
                return false;
            }
            if (leftCurrent == null) {
                return false;
            }
            if (leftCurrent.val != rightCurrent.val) {
                return false;
            }
            listLeft.add(leftCurrent.left);
            listLeft.add(leftCurrent.right);
            listRight.add(rightCurrent.right);
            listRight.add(rightCurrent.left);
            i = i + 2;
        } while (++current <= i);
        return true;
    }

    /**
     * 递归
     */
    public boolean isSymmetricTwo(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        System.out.println(isSymmetricOne(treeNode));
    }


}

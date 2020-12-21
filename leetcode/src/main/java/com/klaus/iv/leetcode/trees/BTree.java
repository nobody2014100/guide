package com.klaus.iv.leetcode.trees;

import com.klaus.iv.leetcode.base.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 给定数组构建二叉树
 */
@Slf4j
public class BTree {

    /**
     * 树的构建
     * [1,2,3,4,5,6,7,8,9]
     *
     * 108. 将有序数组转换为二叉搜索树
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
     * @param data
     * @return
     */
    public static TreeNode buildTree(List<Integer> data) {
        return sortedArrayToBST(data, 0, data.size()-1);
    }

    public static TreeNode sortedArrayToBST(List<Integer> data, int left, int right) {
        if (right < left || left > right) {
            return null;
        }
        int mid = left + ((right-left) / 2);
        TreeNode root = new TreeNode(data.get(mid));
        log.debug("root is :{}, mid is :{}, left is :{}, right is :{}", root, mid, left, right);
        root.setLeft(sortedArrayToBST(data, left, mid -1));
        root.setRight(sortedArrayToBST(data, mid+1, right));
        return root;
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {



        return false;
    }

    /**
     * 树的遍历
     * @param root
     * @param traverseType
     */
    public static void traverseTree(TreeNode root, TreeNode.TraverseType traverseType){



    }




    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(1,2,3,4,5, 6, 7, 8, 9,10,11);
//        List<Integer> data = Arrays.asList(1,2,3,4,5, 6, 7, 8, 9,10,11);
        List<Integer> data = Arrays.asList(1,2,3,4);
        log.info("tree is : \n{}", buildTree(data));


    }
}

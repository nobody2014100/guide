package com.klaus.iv.leetcode.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode(Integer val) { this.value = val; }

    public static enum  TraverseType{
        PREV,MID,AFTER;
    }

    public String nodeToString(TreeNode node) {
        StringBuilder data = new StringBuilder();
        data.append("\t"+ value+ "\n");

        if (left != null && right!= null) {
            data.append("/ \t \t \\ \n");
            data.append(left.value +"\t\t" + right.value);
            data.append(nodeToString(left)).append(nodeToString(right));
        } else if (left!=null) {
            data.append("/ \n" + left.value);
            data.append(nodeToString(left));
        }else if (right!=null) {
            data.append("\\ \n \t\t" + right.value);
            data.append(nodeToString(right));
        }
        return  data.toString();
    }


}

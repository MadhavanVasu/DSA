package Gfg.Easy;

import Gfg.Model.TreeNode;

import java.util.ArrayList;

public class LeftViewOfTree {

    public static void helperFn(TreeNode root, ArrayList<Integer> result, int height) {
        if(result.size()==height-1)
            result.add(root.data);
        if (root.left != null)
            helperFn(root.left, result,height+1);
        if (root.right != null) {
            helperFn(root.right, result, height+1);
        }
    }

    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        helperFn(root, result,1);
        return result;

    }

    public static void main(String[] args) {

    }
}

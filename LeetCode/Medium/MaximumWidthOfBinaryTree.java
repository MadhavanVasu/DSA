package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Pair<T, E> {

    T key;
    E val;

    public Pair(T key, E val) {
        this.key = key;
        this.val = val;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }
}

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(1, root));
        int max = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            int start = 0;
            int end = 0;
            while (qSize-- != 0) {
                Pair<Integer, TreeNode> pair = queue.poll();
                int key = pair.getKey();
                TreeNode node = pair.getVal();
                if (start == 0)
                    start = key;
                else if (end == 0)
                    end = key;
                max = Math.max(max, end - start + 1);
                if (node.left != null)
                    queue.add(new Pair<>(key * 2, node.left));
                if (node.right != null)
                    queue.add(new Pair<>(key * 2 + 1, node.right));
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}

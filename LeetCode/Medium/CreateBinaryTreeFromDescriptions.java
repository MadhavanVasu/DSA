package LeetCode.Medium;

import LeetCode.Model.TreeNode;
import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {

    public class MapElement {
        TreeNode node;
        boolean isRoot;

        public MapElement(TreeNode node, boolean isRoot) {
            this.node = node;
            this.isRoot = isRoot;
        }

        public MapElement(TreeNode node) {
            this.node = node;
            isRoot = true;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, MapElement> map = new HashMap<>();
        for (int[] description : descriptions) {
            int parentNum = description[0];
            int childNum = description[1];
            MapElement parent = new MapElement(new TreeNode(parentNum));
            MapElement child = new MapElement(new TreeNode(childNum), false);
            if (map.containsKey(parentNum)) parent = map.get(parentNum);
            if (map.containsKey(childNum))
                child = map.get(childNum);
            if (description[2] == 1) parent.node.left = child.node;
            else parent.node.right = child.node;
            child.isRoot = false;
            map.put(parentNum, parent);
            map.put(childNum, child);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key).isRoot) return map.get(key).node;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}

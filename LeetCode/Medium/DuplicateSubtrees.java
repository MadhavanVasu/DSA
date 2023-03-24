package LeetCode.Medium;


import LeetCode.Model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtrees {

    public static String postOrder(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) return "#";
        String serial = node.val + "," + postOrder(node.left, map, result) + "," + postOrder(node.right, map, result);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) result.add(node);
        return serial;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        postOrder(root, map, result);
        return result;

    }

}

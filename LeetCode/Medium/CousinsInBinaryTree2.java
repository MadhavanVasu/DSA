//package LeetCode.Medium;
//
//import LeetCode.Model.TreeNode;
//
//import java.util.*;
//
//public class CousinsInBinaryTree2 {
//
//    class QueueNode {
//        TreeNode parent;
//        TreeNode child;
//
//        public QueueNode(TreeNode parent, TreeNode child) {
//            this.parent = parent;
//            this.child = child;
//        }
//
//    }
//
//    public TreeNode replaceValueInTree(TreeNode root) {
//
//        Queue<QueueNode> queue = new LinkedList<>();
//        queue.add(new QueueNode(null, root));
//        TreeNode newRoot = null;
//        while (!queue.isEmpty()) {
//            int qSize = queue.size();
//            List<QueueNode> nodes = new ArrayList<>();
//            int sum = 0;
//            while (qSize-- > 0) {
//                QueueNode node = queue.poll();
//                sum += node.child.val;
//                nodes.add(node);
//                if (node.child.left != null)
//                    queue.add(new QueueNode(node.child, node.child.left));
//                if (node.child.right != null)
//                    queue.add(new QueueNode(node.child, node.child.right));
//            }
//            Map<TreeNode, List<TreeNode>> nodeMap = new HashMap<>();
//            for (QueueNode qNode : nodes) {
//                if (qNode.parent == null) {
//                    newRoot = new TreeNode(0);
//                } else {
//                    if (nodeMap.containsKey(qNode.parent)) nodeMap.get(qNode.parent).add(qNode.child);
//                    else {
//                        List<TreeNode> list = new ArrayList<>();
//                        list.add(qNode.child);
//                        nodeMap.put(qNode.parent, list);
//                    }
//                }
//            }
//            for (TreeNode parent : nodeMap.keySet()) {
//                int tempSum = sum - nodeMap.get(parent).get(0).val;
//                if (nodeMap.get(parent).size() > 1) tempSum -= nodeMap.get(parent).get(1).val;
//
//            }
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}

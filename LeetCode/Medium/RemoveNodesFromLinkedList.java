package LeetCode.Medium;

import LeetCode.Model.ListNode;

import java.util.Stack;

public class RemoveNodesFromLinkedList {

    public ListNode removeNodesRecursive(ListNode head) {
        if (head.next == null) return head;
        ListNode node = removeNodesRecursive(head.next);
        if (node.val > head.val)
            return node;
        else head.next = node;
        return head;
    }

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            if (stack.isEmpty() || stack.peek().val > head.val)
                stack.push(head);
            else {
                while (!stack.isEmpty()) {
                    if (stack.peek().val < head.val) stack.pop();
                    else break;
                }
                stack.push(head);
            }
            head = head.next;
        }
        ListNode result = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = result;
            result = node;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}

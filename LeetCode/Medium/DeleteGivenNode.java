package Medium;

import LeetCode.Model.ListNode;

public class DeleteGivenNode {

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {

        ListNode list = new ListNode(1);

        ListNode temp = list;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        int i = 0;
        temp = list;
        while (i < 3) {
            temp = temp.next;
            i++;
        }
        deleteNode(temp);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

    }

}

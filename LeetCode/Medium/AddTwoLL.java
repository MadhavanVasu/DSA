package Medium;

import LeetCode.Model.ListNode;

public class AddTwoLL {

    //Same logic clean code
    public static ListNode addTwoNumbersClean(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // creating an dummy list
        ListNode curr = dummy; // intialising an pointer
        int carry = 0; // intialising our carry with 0 intiall
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
        // We will add that as well into our list
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0; // intialising our sum
            if (l1 != null) { // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) { // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum / 10; // if we get carry, then divide it by 10 to get the carry
            ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
            curr.next = node; // curr will point to that new node if we get
            curr = curr.next; // update the current every time
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode node = null;
        if (l1 == null) {
            node = l2;
        } else {
            node = l1;
        }
        while (node != null) {
            int sum = node.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            node = node.next;
        }
        if (carry == 1) {
            temp.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode temp = head1;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode head2 = new ListNode(6);
        temp = head2;
        for (int i = 7; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ListNode result = addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}

package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class WinnerOfCircularGame {

    public static int findTheWinner(int n, int k) {

        if(k%n==1)
            return n;

        ListNode head = new ListNode(1);
        ListNode temp  = head;
        for(int i=2;i<=n; i++)
        {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head;
        int count = 0;
        temp = head;
        while(count!=n-1)
        {
            int j = 1;
            while (j!=k-1) {
                temp = temp.next;
                j++;
            }
            if(count!=n-2) {
                temp.next = temp.next.next;
                temp = temp.next;
            }
            else
                temp.next=null;
            count++;
        }
        return temp.val;
    }

    public static void main(String[] args) {

        int n = 5;
        int k = 2;
        System.out.println(findTheWinner(n, k));
    }

}

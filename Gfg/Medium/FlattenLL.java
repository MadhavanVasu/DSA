package Gfg.Medium;

import Gfg.Model.Node;

public class FlattenLL {
    public static Node flatten(Node root)
    {
        Node curr = root;

        while(root !=null && root.next!=null)
        {
            if(curr.bottom==null)
            {
                curr.bottom = root.next;
                root.next = root.next.next;
            }
            else if(curr.bottom.data > root.next.data)
            {
                Node temp = curr.bottom;
                curr.bottom = root.next;
                root.next = root.next.next;
                Node temp2 = root;
                while (temp2.next!=null)
                {
                    if(temp2.next.data> temp.data)
                    {
                        break;
                    }
                    temp2 = temp2.next;
                }
                Node t = temp2.next;
                temp2.next = temp;
                temp.next = t;
            }
            curr = curr.bottom;
        }
        return root;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.bottom = new Node(9);

        Node flat = flatten(head);
        while (flat!=null)
        {
            System.out.println(flat.data);
            flat = flat.bottom;
        }
    }
}

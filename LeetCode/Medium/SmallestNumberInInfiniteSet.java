package LeetCode.Medium;

import java.util.*;

class SmallestInfiniteSet {

    TreeSet<Integer> set;
    int curr;

    public SmallestInfiniteSet() {
        this.set = new TreeSet<>();
        this.curr = 1;
    }

    public int popSmallest() {
        if(set.isEmpty()) {
            curr++;
            return curr-1;
        }
        else
        {
            int ans = set.pollFirst();
            return ans;
        }
    }

    public void addBack(int num) {
        if(curr>num) set.add(num);

    }
}


public class SmallestNumberInInfiniteSet {
    public static void main(String[] args) {
        String[] commands = {"addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"};
        Integer[] inputs = {2, null, null, null, 1, null, null, null};
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("addBack")) {
                System.out.println("hi");
                smallestInfiniteSet.addBack(inputs[i]);
            } else
                System.out.println(smallestInfiniteSet.popSmallest());
        }
    }


}

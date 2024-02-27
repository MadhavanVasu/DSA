package LeetCode.Medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomizedSet {

    Set<Integer> firstSet;
    Set<Integer> secondSet;


    public RandomizedSet() {
        this.firstSet = new HashSet<>();
        this.secondSet = new HashSet<>();
    }

    public boolean insert(int val) {
        if (firstSet.contains(val) || secondSet.contains(val)) return false;
        return firstSet.add(val);
    }

    public boolean remove(int val) {
        if (firstSet.contains(val)) return firstSet.remove(val);
        if (secondSet.contains(val)) return secondSet.remove(val);
        return false;
    }

    public int getRandom() {
        if (!firstSet.isEmpty()) {
            Iterator<Integer> value = firstSet.iterator();
            int val = value.next();
            firstSet.remove(val);
            secondSet.add(val);
            return val;
        } else {
            firstSet.addAll(secondSet);
            secondSet.clear();
            return getRandom();
        }
    }
}
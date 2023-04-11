package LeetCode.Medium;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int minBoats = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            int weight = people[i] + people[j--];
            minBoats++;
            if (weight <= limit)
                i++;
        }
        return minBoats;
    }

    public static void main(String[] args) {

    }

}

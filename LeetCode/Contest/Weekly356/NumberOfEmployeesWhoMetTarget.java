package LeetCode.Contest.Weekly356;

public class NumberOfEmployeesWhoMetTarget {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        int count = 0;
        for (int x : hours) if (x >= target) count++;
        return count;

    }

    public static void main(String[] args) {

    }

}

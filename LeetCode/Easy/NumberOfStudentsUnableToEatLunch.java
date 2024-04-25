package LeetCode.Easy;

public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] sandwich = new int[2];
        for (int x : students) {
            sandwich[x]++;
        }
        for (int x : sandwiches) {
            if (sandwich[x] == 0) return sandwich[0] + sandwich[1];
            sandwich[x]--;
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}

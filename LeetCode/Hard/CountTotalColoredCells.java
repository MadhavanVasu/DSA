package LeetCode.Hard;

public class CountTotalColoredCells {

    public long coloredCells(int n) {
        return n * (long) n + (n - 1) * (long) (n - 1);
    }

    public static void main(String[] args) {

    }

}

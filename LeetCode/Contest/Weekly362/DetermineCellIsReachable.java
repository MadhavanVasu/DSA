package LeetCode.Contest.Weekly362;

public class DetermineCellIsReachable {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int distX = Math.abs(sx - fx);
        int distY = Math.abs(sy - fy);
        int minDistance = Math.min(distX, distY) + Math.abs(distX - distY);
        if (minDistance == 0) return t != 1;
        return minDistance <= t;
    }

    public static void main(String[] args) {

        System.out.println(new DetermineCellIsReachable().isReachableAtTime(1
                , 1
                , 2
                , 2
                , 1));

    }

}
